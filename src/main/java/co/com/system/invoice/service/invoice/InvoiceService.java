package co.com.system.invoice.service.invoice;

import co.com.system.invoice.constants.CodeExceptions;
import co.com.system.invoice.constants.GeneralConstans;
import co.com.system.invoice.constants.PdfTemplate;
import co.com.system.invoice.exception.AppException;
import co.com.system.invoice.mappers.InvoiceDetailToInvoiceDetailPdf;
import co.com.system.invoice.model.Invoice;
import co.com.system.invoice.model.InvoiceDetail;
import co.com.system.invoice.model.Product;
import co.com.system.invoice.persistence.invoice.InvoiceDataProvider;
import co.com.system.invoice.service.pdf.PdfService;
import co.com.system.invoice.service.client.GetClientService;
import co.com.system.invoice.service.payment.type.PaymentTypeService;
import co.com.system.invoice.service.product.GetProductService;
import co.com.system.invoice.service.product.UpdateProductService;
import co.com.system.invoice.service.seller.GetSellerService;
import co.com.system.invoice.service.sellingpoint.GetSellingPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InvoiceService {

    @Autowired private InvoiceDataProvider invoiceDataProvider;
    @Autowired private GetClientService getClientService;
    @Autowired private GetSellerService getSellerService;
    @Autowired private UpdateProductService updateProductService;
    @Autowired private PaymentTypeService paymentTypeService;

    @Autowired private GetSellingPointService getSellingPointService;

    @Autowired private PdfService pdfService;

    @Autowired private InvoiceDetailToInvoiceDetailPdf invoiceDetailToInvoiceDetailPdf;
    @Autowired private GetProductService getProductService;


    public Invoice save(Invoice invoice) throws  AppException {
        validateExceptions(invoice);
     /* invoice.getInvoiceDetails().stream()
             .forEach(invoiceDetail -> updateProductService.updateQuantityInventory(invoiceDetail.getProductId(), -(invoiceDetail.getAmount())));*/
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
        return pdfService.generatePdfFromHtml(PdfTemplate.PDF_INVOICE,parameters,GeneralConstans.INVOICE_INITIAL.concat(invoice.get().getId().toString()));
    }



    private void  validateExceptions(Invoice invoice)  throws  AppException{
        getSellerService.findById(invoice.getSellerId())
                .orElseThrow(()-> new AppException(CodeExceptions.SELLER_NOT_FOUND));

        getClientService.findById(invoice.getClientId())
                .orElseThrow(()-> new AppException(CodeExceptions.CLIENT_NOT_FOUND));

        paymentTypeService.findById(invoice.getPaymentTypeId())
                .orElseThrow(()-> new AppException(CodeExceptions.PAYMENT_TYPE_NOT_FOUND));

        getSellingPointService.findById(invoice.getSellingPointId())
                .orElseThrow(()-> new AppException(CodeExceptions.SELLING_POINT_NOT_FOUND));
    }






}
