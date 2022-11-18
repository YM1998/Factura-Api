package co.com.system.invoice.persistence.product;

import co.com.system.invoice.model.Attribute;
import co.com.system.invoice.model.ProductUpdate;
import co.com.system.invoice.persistence.attribute.AttributeEntity;
import co.com.system.invoice.persistence.product.attribute.ProductAttributeEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductDataProviderUtil {


    public void updateValueAttributes(ProductUpdate productUpdate, ProductEntity product) {
        productUpdate.getProductDTO().getAttributes().forEach(attribute -> updateValueAttribute(attribute, product));
    }

    private void  updateValueAttribute(Attribute attribute, ProductEntity productEntity) {
        productEntity.getAttributeProducts()
                .stream()
                .filter(ptt -> ptt.getAttribute().getId().equals(attribute.getIdAttribute()))
                .findAny()
                .ifPresent(ptt -> ptt.setValue(attribute.getValue()));
    }

    public void addNewAttributes(ProductUpdate productUpdate, ProductEntity product) {
        productUpdate.getProductDTO()
                .getAttributes()
                .stream()
                .filter(attr -> attributeIsNotAssociatedWithTheProduct(attr, product))
                .forEach(attr -> addAttributeInTheProduct(attr, product));

    }

    private Boolean attributeIsNotAssociatedWithTheProduct(Attribute attribute, ProductEntity productEntity) {
        return   productEntity.getAttributeProducts().stream().noneMatch(ptt -> attribute.getIdAttribute().equals(ptt.getAttribute().getId()));
    }

    private void addAttributeInTheProduct(Attribute attribute, ProductEntity productEntity) {
        productEntity.getAttributeProducts().add(ProductAttributeEntity.builder()
                .attribute(AttributeEntity.builder().id(attribute.getIdAttribute()).build())
                .idProductAttribute(attribute.getIdProductAttribute())
                .value(attribute.getValue())
                .product(productEntity)
                .build());
    }



}
