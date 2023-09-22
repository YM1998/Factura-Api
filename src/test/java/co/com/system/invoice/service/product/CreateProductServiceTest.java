package co.com.system.invoice.service.product;

import co.com.system.invoice.constants.CodeExceptions;
import co.com.system.invoice.exception.AppException;
import co.com.system.invoice.model.Attribute;
import co.com.system.invoice.model.Product;
import co.com.system.invoice.persistence.product.ProductDataProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

public class CreateProductServiceTest {

    @InjectMocks  private CreateProductService createProductService;
    @Mock  private ProductDataProvider productDataProvider;

    @Mock private ProductUtil productUtil;
    private Product product;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        product = Product.builder().idProduct(1L).codigo("0001").build();
        product.setAttributes(new ArrayList<>());
        product.getAttributes().add(Attribute.builder().idAttribute(1L).build());
    }


    @Test
    public void save() throws AppException {
        createProductService.save(product);
        Mockito.verify(productDataProvider).save(Mockito.any());
    }



    @Test
    public void saveErrorExistCode() {
        Mockito.when(productDataProvider.existCode(Mockito.anyString()))
                .thenReturn(Boolean.TRUE);
        AppException thrown = Assertions.assertThrows(AppException.class, () -> createProductService.save(product));
        Assertions.assertEquals(CodeExceptions.PRODUCT_CODES_DUPLICATES.getValue(), thrown.getCodError());
    }


}
