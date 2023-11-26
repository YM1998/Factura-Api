package co.com.system.invoice.service.movement.stock.type;

import co.com.system.invoice.model.MovementStockType;
import co.com.system.invoice.persistence.movement.stock.type.MovementStockTypeDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MovementStockTypeService {

    private final  MovementStockTypeDataProvider movementStockTypeDataProvider;



    public Optional<MovementStockType> findById(Integer id) {
        return movementStockTypeDataProvider.findById(id);
    }

    public List<MovementStockType> findAll() {
        return movementStockTypeDataProvider.findAll();
    }


}
