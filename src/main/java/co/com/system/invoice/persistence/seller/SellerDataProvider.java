package co.com.system.invoice.persistence.seller;

import co.com.system.invoice.model.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class SellerDataProvider {

    @Autowired private SellerRepository sellerRepository;
    @Autowired private SellerMapper sellerMapper;

    public Optional<Seller> findById(Long id) {
        Optional<SellerEntity> sellerEntity = sellerRepository.findById(id);
        return sellerEntity.isPresent() ? Optional.of(sellerMapper.toData(sellerEntity.get())) :
               Optional.empty();
    }

}
