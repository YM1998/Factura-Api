package co.com.system.invoice.api.product;


import co.com.system.invoice.exception.AppException;
import co.com.system.invoice.model.Product;
import co.com.system.invoice.model.ProductUpdate;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface IProductController {

    @Secured("ROLE_ADMIN")
    @PostMapping(value = "/save")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void save(@Valid @RequestBody final Product product) throws AppException;

    @Secured("ROLE_ADMIN")
    @PutMapping(value = "/update")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody final ProductUpdate productUpdate) throws AppException;

    @Secured("ROLE_ADMIN")
    @GetMapping(value = "/getAll")
    public List<Product> getAll();

    @Secured("ROLE_ADMIN")
    @GetMapping(value = "/getAll/{sellingPointId}")
    public List<Product> getAll(@PathVariable("sellingPointId") Integer sellingPointId);

    @Secured("ROLE_ADMIN")
    @GetMapping(value = "/find/{id}")
    public Optional<Product> findById(@PathVariable("id") Long idProduct);

    @Secured("ROLE_ADMIN")
    @GetMapping(value = "/findByNameOrCode/{filter}")
    public List<Product> findByNameOrCode(@PathVariable("filter") String filter);

    @Secured("ROLE_ADMIN")
    @GetMapping(value = "/findByCode/{code}")
    public Product findByCode(@PathVariable("code") String code) throws AppException;

    @Secured("ROLE_ADMIN")
    @PutMapping(value = "/update/{id}/status/{statusId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStatus(@PathVariable("id") Long idProduct, @PathVariable("statusId") Long statusId) throws AppException;
}
