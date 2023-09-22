package co.com.system.invoice.model;

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
    private Double cost;
    private Double iva;
    private Double price;
    private Double subtotal;
    private Double total;
    private Long productId;
    private Invoice invoice;
    private String productName;
}
