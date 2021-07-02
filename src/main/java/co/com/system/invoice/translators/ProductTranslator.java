package co.com.system.invoice.translators;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import co.com.system.invoice.domain.ProductDTO;
import co.com.system.invoice.persistence.entity.Attribute;
import co.com.system.invoice.persistence.entity.Category;
import co.com.system.invoice.persistence.entity.Product;
import co.com.system.invoice.persistence.entity.ProductAtribute;
import co.com.system.invoice.persistence.entity.State;

@Component
public class ProductTranslator implements Translator<ProductDTO, Product>{

    @Override
    public Product translate(ProductDTO input) {
        Product product = Product.builder()
                                  .cantidadInventario(input.getInventoryQuantity())
                                  .categoria(Category.builder().idCategoria(input.getIdCategory()).build())
                                  .descripcion(input.getDescription())
                                  .estado(State.builder().idEstado(input.getStatusId()).build())
                                  .idProducto(input.getIdProduct())
                                  .nombre(input.getName())
                                  .precio(input.getPrice())
                                  .costo(input.getCost())
                                  .userCreacion(input.getUserCreation())
                                  .userModificacion(input.getUserModification())
                                  .codigo(input.getCodigo())
                                  .iva(input.getIva())
                                  .build();

        if(input.getAttributes()!=null && !input.getAttributes().isEmpty()) {
            product.setProductosAtributos(input.getAttributes()
                                               .stream()
                                               .map(attr ->  ProductAtribute.builder()
                                                                            .atributo(new Attribute(attr.getIdAttribute()))
                                                                            .idProductoAtributo(attr.getIdProductAttribute())
                                                                            .valor(attr.getValue())
                                                                            .producto(product)
                                                                            .build())
                                               .collect(Collectors.toList()));
        }

        return product;
    }

}
