package co.com.system.invoice.service.seller;

import co.com.system.invoice.model.Seller;
import co.com.system.invoice.persistence.seller.SellerDataProvider;
import co.com.system.invoice.persistence.seller.SellerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetSellerService {

    @Autowired private SellerDataProvider sellerDataProvider;

    public Optional<Seller> findById(Long id) {
        return sellerDataProvider.findById(id);
    }

}
