package co.com.system.invoice.service.movement.stock;

import co.com.system.invoice.constants.CodeExceptions;
import co.com.system.invoice.constants.MovementStockTypes;
import co.com.system.invoice.exception.AppException;
import co.com.system.invoice.model.MovementStock;
import co.com.system.invoice.model.Product;
import co.com.system.invoice.persistence.movement.stock.MovementStockDataProvider;
import co.com.system.invoice.persistence.movement.stock.type.MovementStockTypeDataProvider;
import co.com.system.invoice.service.product.GetProductService;
import co.com.system.invoice.service.product.UpdateProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class MovementStockService {

    @Autowired
    private MovementStockDataProvider movementStockDataProvider;

    @Autowired
    private MovementStockTypeDataProvider movementStockTypeDataProvider;

    @Autowired
    private UpdateProductService updateProductService;

    @Autowired
    private GetProductService getProductService;


    public void save(MovementStock movementStock) throws AppException {
        validateMovement(movementStock);
        Product product = getProductService.findById(movementStock.getProductId())
                         .orElseThrow(()-> new AppException(CodeExceptions.PRODUCT_NOT_EXIST));

        Integer movementValue = determineOperation(movementStock);

        movementStock.setLastValue(product.getInventoryQuantity());
        movementStock.setCurrentValue(product.getInventoryQuantity()+movementValue);
        movementStock.setCreatedAt(LocalDate.now());
        movementStockDataProvider.save(movementStock);

        updateProductService.updateQuantityInventory(product.getIdProduct(), movementValue);
    }


    private void validateMovement(MovementStock movementStock) throws AppException {
        movementStockTypeDataProvider.findById(movementStock.getTypeMovementStockId())
                .orElseThrow(()-> new AppException(CodeExceptions.MOVEMENT_STOCK_TYPE_INVALID));

        ;
    }

    private Integer determineOperation(MovementStock movementStock) {
        if(movementStock.getTypeMovementStockId() == MovementStockTypes.STOCK_OUT.getValue() ||
           movementStock.getTypeMovementStockId() == MovementStockTypes.STOCK_OUT_BY_SALES.getValue()) {
            return -(movementStock.getMovementValue());
        }
        return movementStock.getMovementValue();
    }




}
