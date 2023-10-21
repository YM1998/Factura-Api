package co.com.system.invoice.persistence.product;

import co.com.system.invoice.constants.DateFormats;
import co.com.system.invoice.model.Attribute;
import co.com.system.invoice.model.Product;
import co.com.system.invoice.persistence.attribute.AttributeEntity;
import co.com.system.invoice.persistence.category.CategoryEntity;
import co.com.system.invoice.persistence.product.attribute.ProductAttributeEntity;
import co.com.system.invoice.persistence.state.StateEntity;
import co.com.system.invoice.utils.DateUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public ProductEntity toEntity(Product input) {
        ProductEntity product = ProductEntity.builder()
                .category(CategoryEntity.builder().id(input.getIdCategory()).build())
                .description(input.getDescription())
                .state(StateEntity.builder().id(input.getStatusId()).build())
                .id(input.getIdProduct())
                .name(input.getName())
                .price(input.getPrice())
                .cost(input.getCost())
                .creationUser(input.getUserCreation())
                .modificationUser(input.getUserModification())
                .code(input.getCodigo())
                .iva(input.getIva())
                .build();

        if (input.getAttributes() != null && !input.getAttributes().isEmpty()) {
            product.setAttributeProducts(input.getAttributes()
                    .stream()
                    .map(attr -> ProductAttributeEntity.builder()
                            .attribute(AttributeEntity.builder().id(attr.getIdAttribute()).build())
                            .idProductAttribute(attr.getIdProductAttribute())
                            .value(attr.getValue())
                            .product(product)
                            .build())
                    .collect(Collectors.toList()));
        }

        return product;
      }



    public Product toData(ProductEntity input) {
        return Product.builder()
                .idCategory(input.getCategory()!=null ? input.getCategory().getId() : null)
                .categoryName(input.getCategory()!=null? input.getCategory().getName() : null)
                .creationDate(DateUtils.convertDateToString(input.getCreatedAt(), DateFormats.DD_MM_YYYY.getValue()))
                .description(input.getDescription())
                .idProduct(input.getId())
                .modificationDate(DateUtils.convertDateToString(input.getUpdate(), DateFormats.DD_MM_YYYY.getValue()))
                .name(input.getName())
                .price(input.getPrice())
                .cost(input.getCost())
                .attributes(getAttributes(input))
                .userCreation(input.getCreationUser())
                .userModification(input.getModificationUser())
                .statusId(input.getState()!=null? input.getState().getId():null)
                .statusName(input.getState()!=null? input.getState().getName():null)
                .codigo(input.getCode())
                .iva(input.getIva())
                .build();
    }


    private List<Attribute> getAttributes(ProductEntity input){
        if(input.getAttributeProducts()==null || input.getAttributeProducts().isEmpty())
            return new ArrayList<>();

        return input.getAttributeProducts()
                .stream()
                .map( productAttribute -> Attribute.builder()
                        .idAttribute(productAttribute.getAttribute().getId())
                        .idProductAttribute(productAttribute.getIdProductAttribute())
                        .name(productAttribute.getAttribute().getName())
                        .value(productAttribute.getValue()).build())
                .collect(Collectors.toList());

    }



        public void translateReference(Product input, ProductEntity output) {
            output.setCategory(CategoryEntity.builder().id(input.getIdCategory()).build());
            output.setDescription(input.getDescription());
            output.setState(StateEntity.builder().id(input.getStatusId()).build());
            output.setId(input.getIdProduct());
            output.setName(input.getName());
            output.setPrice(input.getPrice());
            output.setCost(input.getCost());
            output.setCreationUser(input.getUserCreation());
            output.setModificationUser(input.getUserModification());
            output.setCode(input.getCodigo());
            output.setIva(input.getIva());
        }



}
