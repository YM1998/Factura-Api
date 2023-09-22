package co.com.system.invoice.api.client;


import co.com.system.invoice.model.ClientResponse;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;


public interface IClientController {


    @Secured("ROLE_ADMIN")
    @GetMapping(value = "/find/{id}")
    public Optional<ClientResponse> findById(@PathVariable("id") Long id);

}
