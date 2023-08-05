package co.com.system.invoice.persistence.invoice;

import co.com.system.invoice.model.Invoice;
import co.com.system.invoice.model.PaymentType;
import co.com.system.invoice.persistence.client.ClientEntity;
import co.com.system.invoice.persistence.invoice.detail.InvoiceDetailEntity;
import co.com.system.invoice.persistence.invoice.detail.InvoiceDetailMapper;
import co.com.system.invoice.persistence.payment.type.PaymentTypeEntity;
import co.com.system.invoice.persistence.person.PersonEntity;
import co.com.system.invoice.persistence.seller.SellerEntity;
import co.com.system.invoice.persistence.sellingpoint.SellingPointEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class InvoiceMapper {

    @Autowired private InvoiceDetailMapper invoiceDetailMapper;

    public InvoiceEntity toEntity(Invoice invoice){
        InvoiceEntity invoiceEntity =  InvoiceEntity
                .builder()
                .iva(invoice.getIva())
                .client(ClientEntity.builder().id(invoice.getClientId()).build())
                .seller(SellerEntity.builder().id(invoice.getSellerId()).build())
                .paymentType(PaymentTypeEntity.builder().id(invoice.getPaymentTypeId()).build())
                .sellingPoint(SellingPointEntity.builder().id(invoice.getSellingPointId()).build())
                .cost(invoice.getCost())
                .createdAt(invoice.getCreatedAt())
                .id(invoice.getId())
                .total(invoice.getTotal())
                .subtotal(invoice.getSubtotal())
                .build();
        invoiceEntity.setInvoiceDetailEntities(invoice.getInvoiceDetails()
                                              .stream()
                                              .map(invoiceDetail -> {
                                                  InvoiceDetailEntity invoiceDetailEntity = invoiceDetailMapper.toEntity(invoiceDetail);
                                                  invoiceDetailEntity.setInvoice(invoiceEntity);
                                                  return invoiceDetailEntity;
                                                })
                                              .collect(Collectors.toList()));
        return invoiceEntity;
    }






}
