package co.com.system.invoice.api.client;


import co.com.system.invoice.model.Client;
import co.com.system.invoice.model.ClientResponse;
import co.com.system.invoice.model.Product;
import co.com.system.invoice.service.client.GetClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/client")
public class ClientController implements  IClientController{

    private final  GetClientService getClientService;


    @Override
    public Optional<ClientResponse> findById(@PathVariable("id") Long id) {
        Optional<Client> client = getClientService.findById(id);
        return client.isPresent() ? Optional.of(client.get().buildClientResponse()) : Optional.empty();
    }
}
