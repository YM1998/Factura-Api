package co.com.system.invoice.persistence;

import co.com.system.invoice.model.Attribute;
import co.com.system.invoice.model.Product;
import co.com.system.invoice.model.ProductUpdate;
import co.com.system.invoice.persistence.attribute.AttributeEntity;
import co.com.system.invoice.persistence.product.ProductDataProviderUtil;
import co.com.system.invoice.persistence.product.ProductEntity;
import co.com.system.invoice.persistence.product.attribute.ProductAttributeEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class ProductDataProviderUtilTest {


    private ProductDataProviderUtil productDataProviderUtil;
    private ProductUpdate productUpdate;
    private ProductEntity productEntity;
    private Long idAttribute1 = 1L;
    private Long idAttribute2 = 2L;
    private Long idAttribute3 = 3L;
    private String valueAttribute2 = "13";

    @Before
    public void setup() {
        productDataProviderUtil = new ProductDataProviderUtil();

        productUpdate = ProductUpdate.builder().productDTO(Product.builder().attributes(new ArrayList<>()).build()).build();
        productEntity = ProductEntity.builder().attributeProducts(new ArrayList<>()).build();
        productEntity.getAttributeProducts().add(ProductAttributeEntity.builder()
                .attribute(AttributeEntity.builder().id(idAttribute1).build()).value("Rojo")
                .build());

        productEntity.getAttributeProducts().add(ProductAttributeEntity.builder()
                .attribute(AttributeEntity.builder().id(idAttribute2).build()).value(valueAttribute2)
                .build());

        productEntity.getAttributeProducts().add(ProductAttributeEntity.builder()
                .attribute(AttributeEntity.builder().id(idAttribute3).build()).value("15Kg")
                .build());
    }

    @Test
    public void updateAttributes() {

        String value1 = "valueOne";
        String value3 = "valueThree";

        productUpdate.getProductDTO().getAttributes().add(Attribute.builder().idAttribute(idAttribute1).value(value1).build());
        productUpdate.getProductDTO().getAttributes().add(Attribute.builder().idAttribute(idAttribute3).value(value3).build());
        productDataProviderUtil.updateValueAttributes(productUpdate, productEntity);
        Assertions.assertAll(
                () -> Assertions.assertTrue(productEntity.getAttributeProducts().size() == 3),
                () -> Assertions.assertTrue(checkValueAttribute(productEntity, idAttribute1, value1)),
                () -> Assertions.assertTrue(checkValueAttribute(productEntity, idAttribute3, value3)),
                () -> Assertions.assertTrue(checkValueAttribute(productEntity, idAttribute2, valueAttribute2)));
    }


    @Test
    public void addNewAttributes() {

        String value4="valueFour";
        String value5="valueFive";
        String value6="valueSix";

        Long idAttribute4 = 4L;
        Long idAttribute5 = 5L;
        Long idAttribute6 = 6L;

        productUpdate.getProductDTO().getAttributes().add(Attribute.builder().idAttribute(idAttribute4).value(value4).build());
        productUpdate.getProductDTO().getAttributes().add(Attribute.builder().idAttribute(idAttribute5).value(value5).build());
        productUpdate.getProductDTO().getAttributes().add(Attribute.builder().idAttribute(idAttribute6).value(value6).build());
        productDataProviderUtil.addNewAttributes(productUpdate, productEntity);
        Assertions.assertAll(
                () -> Assertions.assertTrue(productEntity.getAttributeProducts().size() == 6),
                () -> Assertions.assertTrue(checkValueAttribute(productEntity, idAttribute4,value4)),
                () -> Assertions.assertTrue(checkValueAttribute(productEntity, idAttribute5, value5)),
                () -> Assertions.assertTrue(checkValueAttribute(productEntity, idAttribute6, value6)));
    }



    private Boolean checkValueAttribute(ProductEntity product, Long idAttribute, String expectedValue) {
        return product.getAttributeProducts()
                      .stream()
                      .anyMatch(attr -> attr.getAttribute().getId().compareTo(idAttribute)==0 && attr.getValue().equals(expectedValue));
    }







}
