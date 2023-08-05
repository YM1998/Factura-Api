package co.com.system.invoice.api.invoice.request;

import co.com.system.invoice.constants.GeneralConstans;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceDetailRequest {


    @NotNull(message = "Ingrese el precio")
    private Double price;

    @NotNull(message = "Ingrese el producto")
    private String productCode;

    @NotNull(message = "Ingrese la cantidad")
    private Integer amount;


    public Double getSubtotal() {
        return this.price*this.amount;
    }

    public Double getTotal() {
        return getSubtotal()+getIva();
    }


    public Double getIva() {
        return getSubtotal() * (GeneralConstans.IVA/100);
    }
}
