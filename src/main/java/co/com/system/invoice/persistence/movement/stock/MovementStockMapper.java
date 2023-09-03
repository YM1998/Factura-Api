package co.com.system.invoice.persistence.movement.stock;

import co.com.system.invoice.model.MovementStock;
import co.com.system.invoice.persistence.movement.stock.type.MovementStockTypeEntity;
import co.com.system.invoice.persistence.product.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class MovementStockMapper {


    public MovementStockEntity toEntity(MovementStock movementStock) {
        return MovementStockEntity.builder()
                .id(movementStock.getId())
                .reason(movementStock.getReason())
                .currentValue(movementStock.getCurrentValue())
                .lastValue(movementStock.getLastValue())
                .movementValue(movementStock.getMovementValue())
                .productEntity(ProductEntity.builder().id(movementStock.getProductId()).build())
                .createdAt(movementStock.getCreatedAt())
                .movementStockTypeEntity(MovementStockTypeEntity.builder().id(movementStock.getTypeMovementStockId()).build())
                .build();
    }


    public MovementStock toData(MovementStockEntity movementStockEntity) {
        return MovementStock.builder()
                .id(movementStockEntity.getId())
                .reason(movementStockEntity.getReason())
                .currentValue(movementStockEntity.getCurrentValue())
                .lastValue(movementStockEntity.getLastValue())
                .movementValue(movementStockEntity.getMovementValue())
                .productId(movementStockEntity.getProductEntity().getId())
                .typeMovementStockId(movementStockEntity.getMovementStockTypeEntity().getId())
                .createdAt(movementStockEntity.getCreatedAt())
                .build();
    }


}
