package co.com.system.invoice.api.invoice;

import co.com.system.invoice.api.invoice.request.InvoiceFindRequest;
import co.com.system.invoice.api.invoice.request.InvoiceRequest;
import co.com.system.invoice.api.invoice.request.InvoiceRequestMapper;
import co.com.system.invoice.api.invoice.response.GeneratePdfResponse;
import co.com.system.invoice.api.invoice.response.InvoiceDataResponse;
import co.com.system.invoice.api.invoice.response.InvoiceResponse;
import co.com.system.invoice.exception.AppException;
import co.com.system.invoice.model.Invoice;
import co.com.system.invoice.service.invoice.InvoiceService;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/invoice")
public class InvoiceController implements  IInvoiceController {

    @Autowired private InvoiceService invoiceService;
    @Autowired private InvoiceRequestMapper invoiceRequestMapper;


    @Override
    public Optional<InvoiceResponse> save(@Valid @RequestBody InvoiceRequest invoice) throws AppException {
        Invoice invoiceResponse = invoiceService.save(invoiceRequestMapper.invoiceRequestToInvoice(invoice));
        return Optional.of(new InvoiceResponse(invoiceResponse.getId()));
    }

    @Override
    public Optional<GeneratePdfResponse> findById(Long id) throws AppException {
        return Optional.of(new GeneratePdfResponse(invoiceService.generateInvoicePdf(id)));
    }

    @Override
    public InvoiceDataResponse findByDate(@RequestBody InvoiceFindRequest invoiceFindRequest) {
       return invoiceService.findByCreatedAt(invoiceFindRequest);
    }
}
