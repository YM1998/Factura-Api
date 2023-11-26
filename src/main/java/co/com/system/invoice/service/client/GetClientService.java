package co.com.system.invoice.service.client;

import co.com.system.invoice.model.Client;
import co.com.system.invoice.persistence.client.ClientDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GetClientService {

    private final ClientDataProvider clientDataProvider;


    public Optional<Client> findById(Long id) {
        return clientDataProvider.findById(id);
    }


}
