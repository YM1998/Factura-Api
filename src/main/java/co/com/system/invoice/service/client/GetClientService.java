package co.com.system.invoice.service.client;

import co.com.system.invoice.model.Client;
import co.com.system.invoice.persistence.client.ClientDataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetClientService {

    @Autowired private ClientDataProvider clientDataProvider;


    public Optional<Client> findById(Long id) {
        return clientDataProvider.findById(id);
    }


}
