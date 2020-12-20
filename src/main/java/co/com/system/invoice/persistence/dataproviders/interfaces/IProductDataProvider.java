package co.com.system.invoice.persistence.dataproviders.interfaces;

import java.util.List;

import co.com.system.invoice.domain.ProductDTO;
import co.com.system.invoice.domain.ProductFilter;

public interface IProductDataProvider {


    public Long countByIdCategoria(Long idCategoria);

    public List<ProductDTO> findByCriteria(ProductFilter productFilter);

    public List<ProductDTO> findAll();

}
