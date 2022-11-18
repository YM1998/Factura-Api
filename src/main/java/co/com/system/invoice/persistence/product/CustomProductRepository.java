package co.com.system.invoice.persistence.product;

import java.util.List;

import co.com.system.invoice.model.ProductFilter;

public interface CustomProductRepository {

    public List<ProductEntity> findByCriteria(final ProductFilter productFilter);

}
