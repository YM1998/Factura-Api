package co.com.system.invoice.api.invoice.request;

import co.com.system.invoice.model.InvoiceDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceRequest {

    @NotNull(message = "Ingrese el clientId")
    private Long clientId;

    @NotNull(message = "Ingrese la forma de pago")
    private Integer paymentTypeId;

    private List<InvoiceDetailRequest> invoiceDetails;
}
