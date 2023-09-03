package co.com.system.invoice.persistence.movement.stock.type;

import co.com.system.invoice.model.MovementStockType;
import co.com.system.invoice.model.State;
import co.com.system.invoice.persistence.state.StateEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovementStockTypeMapper {

    public MovementStockType toData(MovementStockTypeEntity movementStockTypeEntity);


    public MovementStockTypeEntity toEntity(MovementStockType movementStockType);

}
