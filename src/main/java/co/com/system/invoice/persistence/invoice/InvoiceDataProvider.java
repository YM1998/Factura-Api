package co.com.system.invoice.persistence.invoice;


import co.com.system.invoice.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InvoiceDataProvider {

    @Autowired  private InvoiceRepository invoiceRepository;
    @Autowired  private InvoiceMapper invoiceMapper;



    public void save(Invoice invoice) {
       invoiceRepository.save(invoiceMapper.toEntity(invoice));
    }

}
