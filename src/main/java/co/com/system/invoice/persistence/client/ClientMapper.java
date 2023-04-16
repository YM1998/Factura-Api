package co.com.system.invoice.persistence.client;

import co.com.system.invoice.model.Client;
import co.com.system.invoice.persistence.person.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {


    @Autowired private PersonMapper personMapper;

    public Client toData(ClientEntity client) {
        return Client.builder()
                .person(personMapper.toData(client.getPerson()))
                .id(client.getId())
                .build();
    }

}
