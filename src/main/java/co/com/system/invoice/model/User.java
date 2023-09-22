package co.com.system.invoice.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class User {

    private Long id;
    private Person person;
    private String userAccount;
    private String password;
    private List<Roles> roles;

}
