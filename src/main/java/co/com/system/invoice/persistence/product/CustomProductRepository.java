package co.com.system.invoice.persistence.product;

import java.util.List;

import co.com.system.invoice.model.Product;
import co.com.system.invoice.model.ProductFilter;
import org.springframework.data.repository.query.Param;

public interface CustomProductRepository {

    public List<ProductEntity> findByCriteria(final ProductFilter productFilter);

    public List<Product> findByProductWithStockBySellingPoint(final Integer sellingPointId);


}
