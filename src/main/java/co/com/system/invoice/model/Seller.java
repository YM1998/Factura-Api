package co.com.system.invoice.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class Seller {

    private Long id;
    private Person person;
    private String userAccount;
    private String password;

}
