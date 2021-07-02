package co.com.system.invoice.translators;

import org.springframework.stereotype.Component;

import co.com.system.invoice.domain.ProductDTO;
import co.com.system.invoice.persistence.entity.Category;
import co.com.system.invoice.persistence.entity.Product;
import co.com.system.invoice.persistence.entity.State;

@Component
public class ProductTranslatorReference implements TranslatorReference<ProductDTO, Product>{

    @Override
    public void translateReference(ProductDTO input, Product output) {
        output.setCantidadInventario(input.getInventoryQuantity());
        output.setCategoria(Category.builder().idCategoria(input.getIdCategory()).build());
        output.setDescripcion(input.getDescription());
        output.setEstado(State.builder().idEstado(input.getStatusId()).build());
        output.setIdProducto(input.getIdProduct());
        output.setNombre(input.getName());
        output.setPrecio(input.getPrice());
        output.setCosto(input.getCost());
        output.setUserCreacion(input.getUserCreation());
        output.setUserModificacion(input.getUserModification());
        output.setCodigo(input.getCodigo());
        output.setIva(input.getIva());
    }




}
