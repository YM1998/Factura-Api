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
    private double cost;
    private LocalDate createdAt;
    private double iva;
    private double subtotal;
    private double total;
    private Integer paymentTypeId;
    private List<InvoiceDetail> invoiceDetails;
    private Long clientId;
    private Long sellerId;
    private Long sellingPointId;


    public boolean invoiceDetailsIsEmpty() {
        return this.invoiceDetails==null || this.invoiceDetails.isEmpty();
    }


}
