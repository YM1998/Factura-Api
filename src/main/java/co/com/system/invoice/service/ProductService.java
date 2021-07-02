package co.com.system.invoice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.system.invoice.domain.ProductDTO;
import co.com.system.invoice.domain.ProductUpdateDTO;
import co.com.system.invoice.exception.AppException;
import co.com.system.invoice.persistence.dataproviders.ProductDataProvider;
import co.com.system.invoice.service.interfaces.IProductService;

@Service
public class ProductService implements IProductService{

    @Autowired private ProductDataProvider productDataProvider;

    @Override
    @Transactional
    public void save(ProductDTO product) {
         productDataProvider.save(product);
    }

    @Override
    @Transactional
    public void update(ProductUpdateDTO productUpdate) throws AppException {
         productDataProvider.update(productUpdate);
    }

    @Override
    @Transactional(readOnly = true)
    public Long countByIdCategoria(Long idCategoria){
        return productDataProvider.countByIdCategoria(idCategoria);
    }

    @Override
    public ProductDTO findById(Long idProduct) {
       return productDataProvider.findById(idProduct);
    }

    @Override
    public List<ProductDTO> findAll() {
        return productDataProvider.findAll();
    }

    @Override
    public List<ProductDTO> findByNameOrCode(String filter) {
        return productDataProvider.findByNameOrCode(filter);
    }
}
