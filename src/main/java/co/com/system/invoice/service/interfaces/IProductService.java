package co.com.system.invoice.service.interfaces;

import java.util.List;

import co.com.system.invoice.domain.ProductDTO;
import co.com.system.invoice.domain.ProductFilter;

public interface IProductService {


    public Long countByIdCategoria(Long idCategoria);

    public List<ProductDTO> findByCriteria(ProductFilter productFilter);

    public List<ProductDTO> findAll();

}
