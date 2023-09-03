package co.com.system.invoice.api.movement.stock;



import co.com.system.invoice.exception.AppException;
import co.com.system.invoice.model.MovementStock;
import co.com.system.invoice.service.movement.stock.MovementStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping(value = "/movement-stock")
public class MovementStockController implements IMovementStockController {

    @Autowired
    private MovementStockService movementStockService;

    @Override
    public void save(@Valid @RequestBody MovementStock movementStock) throws AppException {
        movementStockService.save(movementStock);
    }
}
