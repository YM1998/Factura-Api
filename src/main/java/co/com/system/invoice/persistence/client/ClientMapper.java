package co.com.system.invoice.persistence.client;

import co.com.system.invoice.model.Client;
import co.com.system.invoice.persistence.person.PersonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ClientMapper {


    private final PersonMapper personMapper;

    public Client toData(ClientEntity client) {
        return Client.builder()
                .person(personMapper.toData(client.getPerson()))
                .id(client.getId())
                .build();
    }

}
