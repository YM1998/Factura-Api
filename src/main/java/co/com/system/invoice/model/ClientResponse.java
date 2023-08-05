package co.com.system.invoice.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class ClientResponse {

    private Long id;
    private String name;
    private String lastName;
    private String nit;
    private String email;
    private String phone;
}
