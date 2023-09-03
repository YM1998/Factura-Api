package co.com.system.invoice.api.movement.stock.type;

import co.com.system.invoice.exception.AppException;
import co.com.system.invoice.model.MovementStockType;
import co.com.system.invoice.service.movement.stock.type.MovementStockTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/movement-stock-type")
public class MovementStockTypeController implements  IMovementStockTypeController {

    @Autowired
    private MovementStockTypeService movementStockTypeService;

    @Override
    public List<MovementStockType> findAll() throws AppException {
        return movementStockTypeService.findAll();
    }
}
