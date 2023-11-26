package co.com.system.invoice.persistence.sellingpoint;

import co.com.system.invoice.model.SellingPoint;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class SellingDataProvider {

    private final SellingPointRepository sellingPointRepository;
    private final SellingMapper sellingMapper;

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
