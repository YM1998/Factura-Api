package co.com.system.invoice.api.client;


import co.com.system.invoice.model.Client;
import co.com.system.invoice.model.Product;
import co.com.system.invoice.service.client.GetClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/client")
public class ClientController implements  IClientController{

    @Autowired private GetClientService getClientService;


    @Override
    public Optional<Client> findById(@PathVariable("id") Long id) {
        return getClientService.findById(id);
    }
}
