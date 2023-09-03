package co.com.system.invoice.service.product;

import co.com.system.invoice.constants.CodeExceptions;
import co.com.system.invoice.exception.AppException;
import co.com.system.invoice.model.Product;
import co.com.system.invoice.persistence.product.ProductDataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GetProductService {
    @Autowired  private ProductDataProvider productDataProvider;


    public Long countByIdCategory(Long idCategory){
        return productDataProvider.countByIdCategory(idCategory);
    }

    public  Optional<Product> findById(Long idProduct) {
        return productDataProvider.findById(idProduct);
    }

    public List<Product> findAll() {
        return productDataProvider.findAll().stream()
                .collect(Collectors.groupingBy(Product::getIdProduct))
                .entrySet().stream()
                .map(this::buildProductAndAttributes)
                .collect(Collectors.toList());
    }


    public List<Product> findBySellingPoint(Integer sellingPointId) {
        return productDataProvider.findBySellingPoint(sellingPointId);
    }



    private Product buildProductAndAttributes(Map.Entry<Long,List<Product>>  productAttributes) {
        Product product = productAttributes.getValue().get(0);
        product.setAttributes(new ArrayList<>());
        productAttributes.getValue().forEach( p -> {
            if(p.getAttribute()!=null)  product.getAttributes().add(p.getAttribute());
        });
        return product;
    }

    public List<Product> findByNameOrCode(String filter) {
        return productDataProvider.findByNameOrCode(filter);
    }

    public Product findByCode(String code) throws AppException {
        return productDataProvider.findByCode(code)
                .orElseThrow(()-> new AppException(CodeExceptions.PRODUCT_CODE_NOT_FOUND));
    }


}
