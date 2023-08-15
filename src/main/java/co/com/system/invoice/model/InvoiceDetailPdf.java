package co.com.system.invoice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class InvoiceDetailPdf {

    private Long id;
    private Integer amount;
    private String iva;
    private String price;
    private String subtotal;
    private String total;
    private String productName;

}
