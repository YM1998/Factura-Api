package co.com.system.invoice.persistence.invoice.detail;

import co.com.system.invoice.model.InvoiceDetail;
import co.com.system.invoice.persistence.product.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class InvoiceDetailMapper {

    public InvoiceDetailEntity toEntity(InvoiceDetail invoiceDetail){
        return  InvoiceDetailEntity
                .builder()
                .total(invoiceDetail.getTotal())
                .price(invoiceDetail.getPrice())
                .iva(invoiceDetail.getIva())
                .cost(invoiceDetail.getCost())
                .amount(invoiceDetail.getAmount())
                .id(invoiceDetail.getId())
                .subtotal(invoiceDetail.getSubtotal())
                .product(ProductEntity.builder().id(invoiceDetail.getProductId()).build())
                .build();
    }


}
