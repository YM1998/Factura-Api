package co.com.system.invoice.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.system.invoice.persistence.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long>{



}
