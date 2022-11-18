package co.com.system.invoice.api.invoice;


import co.com.system.invoice.api.invoice.request.InvoiceRequest;
import co.com.system.invoice.exception.AppException;
import co.com.system.invoice.model.Invoice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**@author Yesid
 */
@RestController
@RequestMapping(value = "/invoice")
public interface IInvoiceController {


    @PostMapping(value = "/save")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void save(@Valid @RequestBody final InvoiceRequest invoice) throws AppException;





}
