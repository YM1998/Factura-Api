package co.com.system.invoice.persistence.product.stock;

import co.com.system.invoice.model.ProductStock;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductEntityMapper {

    public ProductStockEntity toEntity(ProductStock input);

    public ProductStock toData(ProductStockEntity productStockEntity);
}
