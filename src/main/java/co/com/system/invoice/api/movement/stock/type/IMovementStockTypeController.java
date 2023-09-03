package co.com.system.invoice.api.movement.stock.type;

import co.com.system.invoice.exception.AppException;
import co.com.system.invoice.model.MovementStockType;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

public interface IMovementStockTypeController {

    @GetMapping(value = "/getAll")
    public List<MovementStockType> findAll() throws AppException;
}
