package co.com.system.invoice.persistence.invoice;


import co.com.system.invoice.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class InvoiceDataProvider {

    @Autowired  private InvoiceRepository invoiceRepository;
    @Autowired  private InvoiceMapper invoiceMapper;



    public void save(Invoice invoice) {
      InvoiceEntity invoiceEntity =  invoiceRepository.save(invoiceMapper.toEntity(invoice));
      invoice.setId(invoiceEntity.getId());
    }


    public Optional<Invoice> findInvoiceById(Long id) {
        Optional<InvoiceEntity> invoiceEntity = invoiceRepository.findById(id);
        return invoiceEntity.isPresent() ? Optional.of(invoiceMapper.toData(invoiceEntity.get())) : Optional.empty();
    }


}
