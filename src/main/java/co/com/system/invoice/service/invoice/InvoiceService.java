package co.com.system.invoice.service.invoice;

import co.com.system.invoice.api.invoice.request.InvoiceFindRequest;
import co.com.system.invoice.api.invoice.response.InvoiceDataResponse;
import co.com.system.invoice.constants.CodeExceptions;
import co.com.system.invoice.constants.GeneralConstans;
import co.com.system.invoice.constants.MovementStockTypes;
import co.com.system.invoice.constants.PdfTemplate;
import co.com.system.invoice.exception.AppException;
import co.com.system.invoice.mappers.InvoiceDetailToInvoiceDetailPdf;
import co.com.system.invoice.model.Invoice;
import co.com.system.invoice.model.InvoiceDetail;
import co.com.system.invoice.model.MovementStock;
import co.com.system.invoice.persistence.invoice.InvoiceDataProvider;
import co.com.system.invoice.service.movement.stock.MovementStockService;
import co.com.system.invoice.service.pdf.PdfService;
import co.com.system.invoice.service.client.GetClientService;
import co.com.system.invoice.service.payment.type.PaymentTypeService;
import co.com.system.invoice.service.product.GetProductService;
import co.com.system.invoice.service.product.UpdateProductService;
import co.com.system.invoice.service.user.GetUserService;
import co.com.system.invoice.service.sellingpoint.GetSellingPointService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class InvoiceService {

    private final  InvoiceDataProvider invoiceDataProvider;
    private final GetClientService getClientService;
    private final GetUserService getUserService;
    private final UpdateProductService updateProductService;
    private final PaymentTypeService paymentTypeService;

    private final GetSellingPointService getSellingPointService;

    private final PdfService pdfService;

    private final InvoiceDetailToInvoiceDetailPdf invoiceDetailToInvoiceDetailPdf;

    @Autowired private GetProductService getProductService;

    @Autowired private MovementStockService movementStockService;


    public Invoice save(Invoice invoice) throws  AppException {
        validateExceptions(invoice);
        updateStock(invoice);
        invoiceDataProvider.save(invoice);
        return invoice;
    }



    public String generateInvoicePdf(Long id) throws  AppException {
        Optional<Invoice> invoice =  invoiceDataProvider.findInvoiceById(id);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("saleNumber", GeneralConstans.INVOICE_INITIAL.concat(invoice.get().getId().toString()));
        parameters.put("clientNit", invoice.get().getClientNit());
        parameters.put("clientName",invoice.get().getClientName());
        parameters.put("clientPhoneNumber",invoice.get().getClientNumber());
        parameters.put("subtotal", String.format("%,d", invoice.get().getSubtotal().longValue())  );
        parameters.put("total", String.format("%,d", invoice.get().getTotal().longValue()) );
        parameters.put("iva", String.format("%,d", invoice.get().getIva().longValue()));
        parameters.put("items",invoice.get().getInvoiceDetails()
                                            .stream()
                                            .map(invoiceDetailToInvoiceDetailPdf::toInvoiceDetailPdf).collect(Collectors.toList()));

        try {
            return pdfService.generatePdfFromHtml(PdfTemplate.PDF_INVOICE, parameters, GeneralConstans.INVOICE_INITIAL.concat(invoice.get().getId().toString()));
        }catch (AppException apx) {
            throw apx;
        }catch (FileNotFoundException fx){
            throw new AppException(CodeExceptions.PDF_ERROR);
        }
    }

    public InvoiceDataResponse findByCreatedAt(InvoiceFindRequest invoiceFindRequest) {
        InvoiceDataResponse invoiceResponse =
                InvoiceDataResponse.builder()
                                   .invoice(invoiceDataProvider.findByCreatedAt(invoiceFindRequest))
                                   .build();

        if(Objects.nonNull(invoiceResponse.getInvoice())) {
          invoiceResponse.setTotal(invoiceResponse.getInvoice().stream().mapToDouble(Invoice::getTotal).sum());
          invoiceResponse.setSubTotal(invoiceResponse.getInvoice().stream().mapToDouble(Invoice::getSubtotal).sum());
          invoiceResponse.setCost(invoiceResponse.getInvoice().stream().mapToDouble(Invoice::getCost).sum());
          invoiceResponse.setProfits(invoiceResponse.getInvoice().stream().mapToDouble(Invoice::getProfits).sum());
        }

        return invoiceResponse;
    }



    private void updateStock(Invoice invoice) throws AppException {
        for(InvoiceDetail invoiceDetail: invoice.getInvoiceDetails()) {
            movementStockService.save(MovementStock
                    .builder()
                    .typeMovementStockId(MovementStockTypes.STOCK_OUT_BY_SALES.getValue())
                    .movementValue(invoiceDetail.getAmount())
                    .productId(invoiceDetail.getProductId())
                    .sellingPointId(invoice.getSellingPointId())
                    .build());
        }
    }
    private void  validateExceptions(Invoice invoice)  throws  AppException{
        getUserService.findById(invoice.getUserId())
                .orElseThrow(()-> new AppException(CodeExceptions.SELLER_NOT_FOUND));

        getClientService.findById(invoice.getClientId())
                .orElseThrow(()-> new AppException(CodeExceptions.CLIENT_NOT_FOUND));

        paymentTypeService.findById(invoice.getPaymentTypeId())
                .orElseThrow(()-> new AppException(CodeExceptions.PAYMENT_TYPE_NOT_FOUND));

        getSellingPointService.findById(invoice.getSellingPointId())
                .orElseThrow(()-> new AppException(CodeExceptions.SELLING_POINT_NOT_FOUND));
    }






}
