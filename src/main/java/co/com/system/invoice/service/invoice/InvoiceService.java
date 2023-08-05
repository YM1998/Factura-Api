package co.com.system.invoice.service.invoice;

import co.com.system.invoice.constants.CodeExceptions;
import co.com.system.invoice.exception.AppException;
import co.com.system.invoice.model.Client;
import co.com.system.invoice.model.Invoice;
import co.com.system.invoice.persistence.invoice.InvoiceDataProvider;
import co.com.system.invoice.service.client.GetClientService;
import co.com.system.invoice.service.payment.type.PaymentTypeService;
import co.com.system.invoice.service.person.PersonService;
import co.com.system.invoice.service.product.UpdateProductService;
import co.com.system.invoice.service.seller.GetSellerService;
import co.com.system.invoice.service.sellingpoint.GetSellingPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

    @Autowired private InvoiceDataProvider invoiceDataProvider;
    @Autowired private GetClientService getClientService;
    @Autowired private GetSellerService getSellerService;
    @Autowired private UpdateProductService updateProductService;
    @Autowired private PaymentTypeService paymentTypeService;

    @Autowired private GetSellingPointService getSellingPointService;


    public void save(Invoice invoice) throws  AppException {
      validateExceptions(invoice);
     /* invoice.getInvoiceDetails().stream()
             .forEach(invoiceDetail -> updateProductService.updateQuantityInventory(invoiceDetail.getProductId(), -(invoiceDetail.getAmount())));*/
      invoiceDataProvider.save(invoice);
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
