package co.com.system.invoice.persistence.invoice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Long>{


    public List<InvoiceEntity> findByCreatedAtAndSellingPointId(LocalDate createdAt, Integer sellingPointId);

}
