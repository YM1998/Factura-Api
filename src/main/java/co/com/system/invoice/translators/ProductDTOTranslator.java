package co.com.system.invoice.translators;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import co.com.system.invoice.constants.DateFormats;
import co.com.system.invoice.domain.AttributeDTO;
import co.com.system.invoice.domain.ProductDTO;
import co.com.system.invoice.persistence.entity.Product;
import co.com.system.invoice.utils.DateUtils;

@Component
public class ProductDTOTranslator implements Translator<Product, ProductDTO>{

    @Override
    public ProductDTO translate(Product input) {
        return ProductDTO.builder()
                         .inventoryQuantity(input.getCantidadInventario())
                         .idCategory(input.getCategoria()!=null ? input.getCategoria().getIdCategoria() : null)
                         .categoryName(input.getCategoria()!=null? input.getCategoria().getNombre() : null)
                         .creationDate(DateUtils.convertDateToString(input.getFechaCreacion(), DateFormats.DD_MM_YYYY.getValue()))
                         .description(input.getDescripcion())
                         .idProduct(input.getIdProducto())
                         .modificationDate(DateUtils.convertDateToString(input.getFechaModificacion(), DateFormats.DD_MM_YYYY.getValue()))
                         .name(input.getNombre())
                         .price(input.getPrecio())
                         .attributes(getAttributes(input))
                         .userCreation(input.getUserCreacion())
                         .userModification(input.getUserModificacion())
                         .build();
    }


    private List<AttributeDTO> getAttributes(Product input){
        if(input.getProductosAtributos()==null || input.getProductosAtributos().isEmpty())
            return null;

        return input.getProductosAtributos()
                    .stream()
                    .map( productAttribute -> AttributeDTO.builder()
                                                          .idAttribute(productAttribute.getAtributo().getIdAttribute())
                                                          .name(productAttribute.getAtributo().getNombre())
                                                          .valor(productAttribute.getValor()).build())
                    .collect(Collectors.toList());

    }

}
