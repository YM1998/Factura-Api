package co.com.system.invoice.persistence.movement.stock;

import co.com.system.invoice.model.MovementStock;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class MovementStockDataProvider {


    private final MovementStockEntityRepository movementStockEntityRepository;
    private final MovementStockMapper movementStockMapper;


    public void save(MovementStock movementStock) {
        movementStockEntityRepository.save(movementStockMapper.toEntity(movementStock));
    }


}
