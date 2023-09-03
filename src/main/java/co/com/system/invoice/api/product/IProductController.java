package co.com.system.invoice.api.product;


import co.com.system.invoice.exception.AppException;
import co.com.system.invoice.model.Product;
import co.com.system.invoice.model.ProductUpdate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface IProductController {

    @PostMapping(value = "/save")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void save(@Valid @RequestBody final Product product) throws AppException;

    @PutMapping(value = "/update")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody final ProductUpdate productUpdate) throws AppException;

    @GetMapping(value = "/getAll")
    public List<Product> getAll();

    @GetMapping(value = "/getAll/{sellingPointId}")
    public List<Product> getAll(@PathVariable("sellingPointId") Integer sellingPointId);

    @GetMapping(value = "/find/{id}")
    public Optional<Product> findById(@PathVariable("id") Long idProduct);

    @GetMapping(value = "/findByNameOrCode/{filter}")
    public List<Product> findByNameOrCode(@PathVariable("filter") String filter);

    @GetMapping(value = "/findByCode/{code}")
    public Product findByCode(@PathVariable("code") String code) throws AppException;

    @PutMapping(value = "/update/{id}/status/{statusId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStatus(@PathVariable("id") Long idProduct, @PathVariable("statusId") Long statusId) throws AppException;
}
