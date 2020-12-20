package co.com.system.invoice.persistence.dataproviders;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.system.invoice.domain.ProductDTO;
import co.com.system.invoice.domain.ProductFilter;
import co.com.system.invoice.persistence.dataproviders.interfaces.IProductDataProvider;
import co.com.system.invoice.persistence.entity.Product;
import co.com.system.invoice.persistence.repository.ProductImplRepository;
import co.com.system.invoice.persistence.repository.ProductRepository;
import co.com.system.invoice.translators.Translator;

@Component
public class ProductDataProvider implements IProductDataProvider {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductImplRepository productImplRepository;

    @Autowired
    private Translator<Product, ProductDTO> productDTOTranslator;

    @Override
    public Long countByIdCategoria(Long idCategoria) {
        return  productRepository.countByIdCategoria(idCategoria);
    }

    @Override
    public List<ProductDTO> findByCriteria(ProductFilter productFilter) {
        List<Product> products = productImplRepository.findByCriteria(productFilter);
        return translateList(products);
    }

    @Override
    public List<ProductDTO> findAll() {
        List<Product> products = productRepository.findAll();
        return translateList(products);
    }

    private List<ProductDTO> translateList(final List<Product> products){
        return products.stream()
                .map(productDTOTranslator::translate)
                .collect(Collectors.toList());
    }

}
