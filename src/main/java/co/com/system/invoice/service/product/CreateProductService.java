package co.com.system.invoice.service.product;

import co.com.system.invoice.constants.CodeExceptions;
import co.com.system.invoice.exception.AppException;
import co.com.system.invoice.model.Product;
import co.com.system.invoice.persistence.product.ProductDataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateProductService {

    @Autowired  private ProductDataProvider productDataProvider;

    @Autowired private ProductUtil productUtil;

    @Transactional
    public void save(Product product)  throws AppException {
        productUtil.validateAttributeNotDuplicates(product.getAttributes());
        validateCodeCreate(product);
        productDataProvider.save(product);
    }

    private void validateCodeCreate(final Product product) throws AppException{
        if(productDataProvider.existCode(product.getCodigo()))
            throw new AppException(CodeExceptions.PRODUCT_CODES_DUPLICATES);
    }

}
