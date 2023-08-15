package co.com.system.invoice.model;

import co.com.system.invoice.persistence.invoice.detail.InvoiceDetailEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class Invoice {

    private Long id;
    private Double cost;
    private LocalDate createdAt;
    private Double iva;
    private Double subtotal;
    private Double total;
    private Integer paymentTypeId;
    private String paymentTypeName;
    private List<InvoiceDetail> invoiceDetails;
    private Long clientId;
    private String clientNit;
    private String clientName;
    private String clientNumber;
    private Long sellerId;
    private Long sellingPointId;


    public boolean invoiceDetailsIsEmpty() {
        return this.invoiceDetails==null || this.invoiceDetails.isEmpty();
    }


}
