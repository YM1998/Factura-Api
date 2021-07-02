package co.com.system.invoice.persistence.repository;

import java.util.List;

import co.com.system.invoice.domain.ProductFilter;
import co.com.system.invoice.persistence.entity.Product;

public interface CustomProductRepository {

    public List<Product> findByCriteria(final ProductFilter productFilter);

}
