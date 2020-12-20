package co.com.system.invoice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.system.invoice.domain.ProductDTO;
import co.com.system.invoice.domain.ProductFilter;
import co.com.system.invoice.persistence.dataproviders.interfaces.IProductDataProvider;
import co.com.system.invoice.service.interfaces.IProductService;

@Service
public class ProductService implements IProductService{

    @Autowired
    private IProductDataProvider productDataProvider;

    @Override
    @Transactional(readOnly = true)
    public Long countByIdCategoria(Long idCategoria){
        return productDataProvider.countByIdCategoria(idCategoria);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> findByCriteria(ProductFilter productFilter) {
        return productDataProvider.findByCriteria(productFilter);
    }

    @Override
    public List<ProductDTO> findAll() {
        return productDataProvider.findAll();
    }

}
