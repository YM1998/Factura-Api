package co.com.system.invoice.service.sellingpoint;

import co.com.system.invoice.model.SellingPoint;
import co.com.system.invoice.persistence.sellingpoint.SellingDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GetSellingPointService {

    private final SellingDataProvider sellingDataProvider;

    public List<SellingPoint> getAll() {
        return sellingDataProvider.findAll();
    }

    public Optional<SellingPoint> findById(Integer id) {
        return sellingDataProvider.findById(id);
    }

}
