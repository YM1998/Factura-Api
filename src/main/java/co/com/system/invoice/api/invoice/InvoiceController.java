package co.com.system.invoice.api.invoice;

import co.com.system.invoice.api.invoice.request.InvoiceRequest;
import co.com.system.invoice.api.invoice.request.InvoiceRequestMapper;
import co.com.system.invoice.exception.AppException;
import co.com.system.invoice.service.invoice.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/invoice")
public class InvoiceController implements  IInvoiceController {

    @Autowired private InvoiceService invoiceService;
    @Autowired private InvoiceRequestMapper invoiceRequestMapper;


    @Override
    public void save(@Valid @RequestBody InvoiceRequest invoice) throws AppException {
        invoiceService.save(invoiceRequestMapper.invoiceRequestToInvoice(invoice,1L));
    }
}
