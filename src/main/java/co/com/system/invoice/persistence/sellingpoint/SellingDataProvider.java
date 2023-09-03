package co.com.system.invoice.persistence.sellingpoint;

import co.com.system.invoice.model.SellingPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class SellingDataProvider {

    @Autowired private SellingPointRepository sellingPointRepository;
    @Autowired private SellingMapper sellingMapper;

    public List<SellingPoint> findAll() {
        return sellingPointRepository.findAll().stream().map(sellingMapper::toData)
                .collect(Collectors.toList());
    }


    public Optional<SellingPoint> findById(Integer id) {
        Optional<SellingPointEntity> sellingPointEntity = sellingPointRepository.findById(id);
        return sellingPointEntity.isPresent() ? Optional.of(sellingMapper.toData(sellingPointEntity.get())):
               Optional.empty();
    }

}
