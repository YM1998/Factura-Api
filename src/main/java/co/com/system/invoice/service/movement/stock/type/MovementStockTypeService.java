package co.com.system.invoice.service.movement.stock.type;

import co.com.system.invoice.model.MovementStockType;
import co.com.system.invoice.persistence.movement.stock.type.MovementStockTypeDataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovementStockTypeService {

    @Autowired
    private MovementStockTypeDataProvider movementStockTypeDataProvider;



    public Optional<MovementStockType> findById(Integer id) {
        return movementStockTypeDataProvider.findById(id);
    }

    public List<MovementStockType> findAll() {
        return movementStockTypeDataProvider.findAll();
    }


}
