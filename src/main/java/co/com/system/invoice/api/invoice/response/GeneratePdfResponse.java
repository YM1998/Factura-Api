package co.com.system.invoice.api.invoice.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeneratePdfResponse {
    private String filePdf;
}
