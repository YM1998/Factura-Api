package co.com.system.invoice.service.product;

import co.com.system.invoice.constants.CodeExceptions;
import co.com.system.invoice.exception.AppException;
import co.com.system.invoice.model.Product;
import co.com.system.invoice.model.ProductStock;
import co.com.system.invoice.persistence.product.ProductDataProvider;
import co.com.system.invoice.service.product.stock.ProductStockService;
import co.com.system.invoice.service.sellingpoint.GetSellingPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateProductService {

    @Autowired  private ProductDataProvider productDataProvider;

    @Autowired private ProductUtil productUtil;

    @Autowired private GetSellingPointService getSellingPointService;

    @Autowired private ProductStockService productStockService;

    @Transactional
    public void save(Product product)  throws AppException {
        productUtil.validateAttributeNotDuplicates(product.getAttributes());
        validateCodeCreate(product);
        Product productSave = productDataProvider.save(product);

        getSellingPointService.getAll().stream()
                .forEach(sellingPoint -> {
                    ProductStock productStock = ProductStock
                            .builder()
                            .productId(productSave.getIdProduct())
                            .sellingPointId(sellingPoint.getId())
                            .stock(0)
                            .build();
                    productStockService.save(productStock);
                });
    }

    private void validateCodeCreate(final Product product) throws AppException{
        if(productDataProvider.existCode(product.getCodigo()))
            throw new AppException(CodeExceptions.PRODUCT_CODES_DUPLICATES);
    }

}
