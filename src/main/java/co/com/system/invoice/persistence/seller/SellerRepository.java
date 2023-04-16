package co.com.system.invoice.persistence.seller;

import co.com.system.invoice.persistence.client.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository  extends JpaRepository<SellerEntity, Long> {
}
