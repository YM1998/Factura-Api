package co.com.system.invoice.service.movement.stock;

import co.com.system.invoice.constants.CodeExceptions;
import co.com.system.invoice.constants.MovementStockTypes;
import co.com.system.invoice.exception.AppException;
import co.com.system.invoice.model.MovementStock;
import co.com.system.invoice.model.ProductStock;
import co.com.system.invoice.persistence.movement.stock.MovementStockDataProvider;
import co.com.system.invoice.persistence.movement.stock.type.MovementStockTypeDataProvider;
import co.com.system.invoice.service.product.GetProductService;
import co.com.system.invoice.service.product.stock.ProductStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class MovementStockService {

    @Autowired
    private MovementStockDataProvider movementStockDataProvider;

    @Autowired
    private MovementStockTypeDataProvider movementStockTypeDataProvider;

    @Autowired
    private ProductStockService productStockService;

    @Autowired
    private GetProductService getProductService;


    @Transactional
    public void save(MovementStock movementStock) throws AppException {
        validateMovement(movementStock);
        ProductStock productStock = productStockService.findByProduct(movementStock.getProductId(), movementStock.getSellingPointId())
                         .orElseThrow(()-> new AppException(CodeExceptions.PRODUCT_NOT_EXIST));

        Integer movementValue = determineOperation(movementStock);

        movementStock.setLastValue(productStock.getStock());
        movementStock.setCurrentValue(productStock.getStock()+movementValue);
        movementStock.setCreatedAt(LocalDate.now());
        movementStockDataProvider.save(movementStock);

        if(movementStock.getTypeMovementStockId() == MovementStockTypes.STOCK_UPDATE.getValue()) {
            productStockService.updateQuantityInventory(productStock.getProductId(), movementValue, movementStock.getSellingPointId());
        }else{
            productStockService.updateQuantityInventoryByOperation(productStock.getProductId(), movementValue,  movementStock.getSellingPointId());
        }

    }


    private void validateMovement(MovementStock movementStock) throws AppException {
        movementStockTypeDataProvider.findById(movementStock.getTypeMovementStockId())
                .orElseThrow(()-> new AppException(CodeExceptions.MOVEMENT_STOCK_TYPE_INVALID));
    }

    private Integer determineOperation(MovementStock movementStock) {
        if(movementStock.getTypeMovementStockId() == MovementStockTypes.STOCK_OUT.getValue() ||
           movementStock.getTypeMovementStockId() == MovementStockTypes.STOCK_OUT_BY_SALES.getValue()) {
            return -(movementStock.getMovementValue());
        }
        return movementStock.getMovementValue();
    }




}
