package co.com.system.invoice.api.invoice;


import co.com.system.invoice.api.invoice.request.InvoiceFindRequest;
import co.com.system.invoice.api.invoice.request.InvoiceRequest;
import co.com.system.invoice.api.invoice.response.GeneratePdfResponse;
import co.com.system.invoice.api.invoice.response.InvoiceDataResponse;
import co.com.system.invoice.api.invoice.response.InvoiceResponse;
import co.com.system.invoice.constants.RolesEnum;
import co.com.system.invoice.exception.AppException;
import co.com.system.invoice.model.Invoice;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**@author Yesid
 */
public interface IInvoiceController {


    @Secured({RolesEnum.ROLE_ADMIN, RolesEnum.ROLE_SELLER})
    @PostMapping(value = "/save")
    public Optional<InvoiceResponse> save(@Valid @RequestBody final InvoiceRequest invoice) throws AppException;


    @Secured({RolesEnum.ROLE_ADMIN, RolesEnum.ROLE_SELLER})
    @GetMapping(value = "/generate-pdf/{id}")
    public Optional<GeneratePdfResponse> findById(@PathVariable  Long id) throws AppException;

    @Secured({RolesEnum.ROLE_ADMIN, RolesEnum.ROLE_SELLER})
    @PostMapping(value = "/getByDate")
    public InvoiceDataResponse findByDate(@RequestBody InvoiceFindRequest invoiceFindRequest);





}
