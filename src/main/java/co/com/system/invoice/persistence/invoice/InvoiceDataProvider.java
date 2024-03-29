package co.com.system.invoice.persistence.invoice;


import co.com.system.invoice.api.invoice.request.InvoiceFindRequest;
import co.com.system.invoice.model.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class InvoiceDataProvider {

    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;



    public void save(Invoice invoice) {
      InvoiceEntity invoiceEntity =  invoiceRepository.save(invoiceMapper.toEntity(invoice));
      invoice.setId(invoiceEntity.getId());
    }


    public Optional<Invoice> findInvoiceById(Long id) {
        Optional<InvoiceEntity> invoiceEntity = invoiceRepository.findById(id);
        return invoiceEntity.isPresent() ? Optional.of(invoiceMapper.toData(invoiceEntity.get())) : Optional.empty();
    }

    public List<Invoice> findByCreatedAt(InvoiceFindRequest invoiceFindRequest) {
        return invoiceRepository.findByCreatedAtAndSellingPointId(invoiceFindRequest.getDate(), invoiceFindRequest.getSellingPointId())
                                .stream()
                                .map(invoiceMapper::toData)
                                .collect(Collectors.toList());

    }


}
