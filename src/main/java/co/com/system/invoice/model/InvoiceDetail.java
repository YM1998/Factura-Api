package co.com.system.invoice.model;

import co.com.system.invoice.persistence.invoice.InvoiceEntity;
import co.com.system.invoice.persistence.product.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class InvoiceDetail {

    private Long id;
    private Integer amount;
    private Double cost;
    private Double iva;
    private Double price;
    private Double subtotal;
    private Double total;
    private Long productId;
    private Invoice invoice;
    private String productName;
}
