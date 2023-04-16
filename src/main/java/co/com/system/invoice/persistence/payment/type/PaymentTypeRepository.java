package co.com.system.invoice.persistence.payment.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentTypeRepository  extends JpaRepository<PaymentTypeEntity, Integer> {
    public List<PaymentTypeEntity> findAllByOrderByNameAsc();
}
