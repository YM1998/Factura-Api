package co.com.system.invoice.api.movement.stock;


import co.com.system.invoice.exception.AppException;
import co.com.system.invoice.model.MovementStock;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


public interface IMovementStockController {
    @Secured("ROLE_ADMIN")
    @PostMapping(value = "/save")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void save(@Valid @RequestBody final MovementStock movementStock) throws AppException;
}
