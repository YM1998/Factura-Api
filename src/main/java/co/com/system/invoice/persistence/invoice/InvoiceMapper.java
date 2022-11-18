package co.com.system.invoice.persistence.invoice;

import co.com.system.invoice.model.Invoice;
import co.com.system.invoice.persistence.invoice.detail.InvoiceDetailMapper;
import co.com.system.invoice.persistence.person.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class InvoiceMapper {

    @Autowired private InvoiceDetailMapper invoiceDetailMapper;

    public InvoiceEntity toEntity(Invoice invoice){
        return InvoiceEntity
                .builder()
                .iva(invoice.getIva())
                .client(PersonEntity.builder().id(invoice.getClientId()).build())
                .seller(PersonEntity.builder().id(invoice.getSellerId()).build())
                .cost(invoice.getCost())
                .createdAt(invoice.getCreatedAt())
                .id(invoice.getId())
                .total(invoice.getTotal())
                .subtotal(invoice.getSubtotal())
                .invoiceDetailEntities(invoice.getInvoiceDetails().stream().map(invoiceDetailMapper::toEntity).collect(Collectors.toList()))
                .build();
    }






}
