package co.com.system.invoice.service.invoice;

import co.com.system.invoice.constants.CodeExceptions;
import co.com.system.invoice.exception.AppException;
import co.com.system.invoice.model.Invoice;
import co.com.system.invoice.persistence.invoice.InvoiceDataProvider;
import co.com.system.invoice.service.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

    @Autowired private InvoiceDataProvider invoiceDataProvider;
    @Autowired private PersonService personService;


    public void save(Invoice invoice) throws  AppException {
      validateExceptionsSave(invoice);
      invoiceDataProvider.save(invoice);
    }

    private void  validateExceptionsSave(Invoice invoice)  throws  AppException{
        personService.findById(invoice.getSellerId())
                .orElseThrow(()-> new AppException(CodeExceptions.SELLER_NOT_FOUND));

        personService.findById(invoice.getClientId())
                .orElseThrow(()-> new AppException(CodeExceptions.CLIENT_NOT_FOUND));
    }






}
