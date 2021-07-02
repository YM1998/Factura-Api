package co.com.system.invoice.service.interfaces;

import java.util.List;

import co.com.system.invoice.domain.ProductDTO;
import co.com.system.invoice.domain.ProductUpdateDTO;
import co.com.system.invoice.exception.AppException;

public interface IProductService {

    public void save(final ProductDTO product);

    public void update(ProductUpdateDTO productUpdate)  throws AppException;

    public Long countByIdCategoria(Long idCategoria);

    public ProductDTO findById(Long idProduc);

    public List<ProductDTO> findAll();

    public List<ProductDTO> findByNameOrCode(String filter);

}
