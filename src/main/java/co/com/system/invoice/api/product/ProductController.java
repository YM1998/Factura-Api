package co.com.system.invoice.api.product;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import co.com.system.invoice.service.product.CreateProductService;
import co.com.system.invoice.service.product.GetProductService;
import co.com.system.invoice.service.product.UpdateProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.system.invoice.model.Product;
import co.com.system.invoice.model.ProductUpdate;
import co.com.system.invoice.exception.AppException;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/product")
public class ProductController implements  IProductController {

    private final GetProductService getProductService;
    private final CreateProductService createProductService;
    private final UpdateProductService updateProductService;


    @Override
    public void save(@Valid @RequestBody final Product product) throws AppException {
        createProductService.save(product);
    }

    @Override
    public void update(@Valid @RequestBody final ProductUpdate productUpdate) throws AppException {
        updateProductService.update(productUpdate);
    }

    @Override
    public List<Product> getAll(){
         return getProductService.findAll();
    }

    @Override
    public List<Product> getAll(Integer sellingPointId) {
        return getProductService.findByProductWithStockBySellingPoint(sellingPointId);
    }

    @Override
    public Optional<Product> findById(@PathVariable("id") Long idProduct){
         return getProductService.findById(idProduct);
    }

    @Override
    public List<Product> findByNameOrCode(@PathVariable("filter") String filter){
         return getProductService.findByNameOrCode(filter);
    }

    @Override
    public Product findByCode(String code) throws  AppException{
        return getProductService.findByCode(code);
    }

    @Override
    public void updateStatus(Long idProduct, Long statusId) throws AppException {
        updateProductService.updateStatus(idProduct, statusId);
    }


}
