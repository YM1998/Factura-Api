package co.com.system.invoice.persistence.movement.stock.type;

import co.com.system.invoice.model.MovementStockType;
import co.com.system.invoice.persistence.movement.stock.MovementStockEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MovementStockTypeDataProvider {

    @Autowired
    private MovementStockTypeMapper movementStockTypeMapper;

    @Autowired
    private MovementStockTypeRepository movementStockTypeRepository;


    public Optional<MovementStockType> findById(Integer id) {
        Optional<MovementStockTypeEntity> movementStockTypeEntity = movementStockTypeRepository.findById(id);
        return movementStockTypeEntity.isPresent() ?
                Optional.of(movementStockTypeMapper.toData(movementStockTypeEntity.get())) : Optional.empty();
    }

    public List<MovementStockType> findAll() {
        return movementStockTypeRepository
                .findAll()
                .stream()
                .map(movementStockTypeMapper::toData).collect(Collectors.toList());

    }


}
