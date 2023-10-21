package co.com.system.invoice.service.product;

import co.com.system.invoice.constants.CodeExceptions;
import co.com.system.invoice.exception.AppException;
import co.com.system.invoice.model.Product;
import co.com.system.invoice.model.ProductUpdate;
import co.com.system.invoice.persistence.product.ProductDataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UpdateProductService {

    @Autowired  private ProductDataProvider productDataProvider;
    @Autowired private ProductUtil productUtil;



    @Transactional
    public void update(ProductUpdate productUpdate) throws AppException {
        productUtil.validateAttributeNotDuplicates(productUpdate.getProductDTO().getAttributes());
        validateCodeUpdate(productUpdate.getProductDTO());
        productDataProvider.update(productUpdate);
    }

    private void validateCodeUpdate(final Product product) throws AppException{
        if(productDataProvider.existCodeForOtherRecords(product.getCodigo(), product.getIdProduct()))
            throw new AppException(CodeExceptions.PRODUCT_CODES_DUPLICATES);
    }

    @Transactional
    public void updateStatus(Long idProduct, Long idStatus) throws AppException {
        productDataProvider.updateStatus(idProduct, idStatus);
    }

}
