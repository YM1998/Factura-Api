package co.com.system.invoice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {

    private Long id;
    private Person person;


    public ClientResponse buildClientResponse(){
        return ClientResponse.builder()
                             .id(id)
                             .name(person.getName())
                             .email(person.getEmail())
                             .nit(person.getNit())
                             .phone(person.getPhone())
                             .lastName(person.getLastName())
                             .build();
    }



}
