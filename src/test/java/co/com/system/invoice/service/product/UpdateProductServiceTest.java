package co.com.system.invoice.service.product;

import co.com.system.invoice.constants.CodeExceptions;
import co.com.system.invoice.exception.AppException;
import co.com.system.invoice.model.Attribute;
import co.com.system.invoice.model.Product;
import co.com.system.invoice.model.ProductUpdate;
import co.com.system.invoice.persistence.product.ProductDataProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

public class UpdateProductServiceTest {

    @InjectMocks private UpdateProductService updateProductService;
    @Mock private ProductDataProvider productDataProvider;
    @Mock private ProductUtil productUtil;
    private Product product;
    private ProductUpdate productUpdate;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        product = Product.builder().idProduct(1L).codigo("0001").build();
        product.setAttributes(new ArrayList<>());
        product.getAttributes().add(Attribute.builder().idAttribute(1L).build());

        productUpdate = ProductUpdate.builder().productDTO(product).build();
    }


    @Test
    public void update()throws AppException {
        updateProductService.update(productUpdate);
        Mockito.verify(productDataProvider).update(Mockito.any());
    }


    @Test
    public void updateErrorExistCode() {
        Mockito.when(productDataProvider.existCodeForOtherRecords(Mockito.anyString(), Mockito.anyLong()))
                .thenReturn(Boolean.TRUE);
        AppException thrown = Assertions.assertThrows(AppException.class, () -> updateProductService.update(productUpdate));
        Assertions.assertEquals(CodeExceptions.PRODUCT_CODES_DUPLICATES.getValue(), thrown.getCodError());
    }


}
