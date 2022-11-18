package co.com.system.invoice.model;

import co.com.system.invoice.persistence.invoice.InvoiceEntity;
import co.com.system.invoice.persistence.product.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class InvoiceDetail {

    private Long id;
    private Integer amount;
    private double cost;
    private double iva;
    private double price;
    private double subtotal;
    private double total;
    private Long productId;
}
