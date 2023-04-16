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
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class GetProductServiceTest {
    @InjectMocks
    private GetProductService getProductService;
    @Mock
    private ProductDataProvider productDataProvider;
    private Product product;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        product = Product.builder().idProduct(1L).codigo("0001").build();
        product.setAttributes(new ArrayList<>());
        product.getAttributes().add(Attribute.builder().idAttribute(1L).build());
    }


    @Test
    public void countByIdCategory() {
        Long result = 3L;
        Mockito.when(productDataProvider.countByIdCategory(Mockito.anyLong())).thenReturn(result);
        Assertions.assertEquals(result, getProductService.countByIdCategory(1L));
    }

    @Test
    public void findById() {
        Mockito.when(productDataProvider.findById(Mockito.anyLong())).thenReturn(Optional.of(product));
        Assertions.assertEquals(product, getProductService.findById(1L));
    }

    @Test
    public void findByNameOrCode() {
        Mockito.when(productDataProvider.findByNameOrCode(Mockito.anyString())).thenReturn(Collections.emptyList());
        Assertions.assertNotNull(getProductService.findByNameOrCode("filter"));
    }


    @Test
    public void findByCode() throws AppException {
        Mockito.when(productDataProvider.findByCode(Mockito.anyString())).thenReturn(Optional.of(product));
        Assertions.assertNotNull(getProductService.findByCode("00013"));
    }

    @Test
    public void findByCodeCaseCodeNotFound() throws AppException {
        Mockito.when(productDataProvider.findByCode(Mockito.anyString())).thenReturn(Optional.empty());
        AppException thrown = Assertions.assertThrows(AppException.class, () ->getProductService.findByCode("009"));
        Assertions.assertEquals(CodeExceptions.PRODUCT_CODE_NOT_FOUND.getValue(), thrown.getCodError());
    }

    @Test
    public void findAll() {

        Long idProduct1=1L;
        Long idProduct2=2L;
        Long idProduct3=3L;

        Long idAttribute1=1L;
        Long idAttribute2=2L;
        Long idAttribute3=3L;

        List<Product> productsList = new ArrayList<>();
        productsList.add(Product.builder().idProduct(idProduct1).attribute(Attribute.builder().idAttribute(idAttribute1).build()).build());
        productsList.add(Product.builder().idProduct(idProduct1).attribute(Attribute.builder().idAttribute(idAttribute2).build()).build());
        productsList.add(Product.builder().idProduct(idProduct1).attribute(Attribute.builder().idAttribute(idAttribute3).build()).build());
        productsList.add(Product.builder().idProduct(idProduct2).attribute(Attribute.builder().idAttribute(idAttribute1).build()).build());
        productsList.add(Product.builder().idProduct(idProduct2).attribute(Attribute.builder().idAttribute(idAttribute2).build()).build());
        productsList.add(Product.builder().idProduct(idProduct3).build());
        Mockito.when(productDataProvider.findAll()).thenReturn(productsList);


        List<Product> productsResult = getProductService.findAll();

        Product product1 = productsResult.stream().filter(p -> p.getIdProduct().compareTo(idProduct1)==0).findAny().get();
        Product product2 = productsResult.stream().filter(p -> p.getIdProduct().compareTo(idProduct2)==0).findAny().get();
        Product product3 = productsResult.stream().filter(p -> p.getIdProduct().compareTo(idProduct3)==0).findAny().get();

        Assertions.assertAll(
                () -> Assertions.assertTrue(productsResult.size() == 3),
                () -> Assertions.assertTrue(findAttributeInProduct(product1, idAttribute1)),
                () -> Assertions.assertTrue(findAttributeInProduct(product1, idAttribute2)),
                () -> Assertions.assertTrue(findAttributeInProduct(product1, idAttribute3)),
                () -> Assertions.assertTrue(findAttributeInProduct(product2, idAttribute1)),
                () -> Assertions.assertTrue(findAttributeInProduct(product2, idAttribute2)),
                () -> Assertions.assertTrue(product3.getAttributes().isEmpty()));
    }



    private Boolean findAttributeInProduct(Product product, Long idAttribute) {
        return product.getAttributes().stream().anyMatch(attr -> attr.getIdAttribute().compareTo(idAttribute)==0);
    }
}


