package co.com.system.invoice.api.invoice.response;

import co.com.system.invoice.model.Invoice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDataResponse {

    private List<Invoice> invoice;
    private Double total;
    private Double subTotal;
    private Double cost;
    private Double profits;
}
