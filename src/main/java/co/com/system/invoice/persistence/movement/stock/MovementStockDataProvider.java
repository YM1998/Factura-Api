package co.com.system.invoice.persistence.movement.stock;

import co.com.system.invoice.model.MovementStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MovementStockDataProvider {


    @Autowired
    private MovementStockEntityRepository movementStockEntityRepository;

    @Autowired
    private MovementStockMapper movementStockMapper;


    public void save(MovementStock movementStock) {
        movementStockEntityRepository.save(movementStockMapper.toEntity(movementStock));
    }


}
