package co.com.system.invoice.api.invoice.request;

import co.com.system.invoice.model.InvoiceDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceRequest {

    @NotNull(message = "Ingrese el clientId")
    @NotBlank(message = "Ingrese el clientId")
    private Long sellerId;

    @NotNull(message = "Ingrese el clientId")
    @NotBlank(message = "Ingrese el clientId")
    private Long clientId;

    private List<InvoiceDetailRequest> invoiceDetails;
}
