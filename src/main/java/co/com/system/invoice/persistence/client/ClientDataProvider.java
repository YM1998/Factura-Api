package co.com.system.invoice.persistence.client;

import co.com.system.invoice.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class ClientDataProvider {

    @Autowired ClientRepository clientRepository;
    @Autowired ClientMapper clientMapper;

    public Optional<Client> findById(Long id) {
        Optional<ClientEntity> clientEntity = clientRepository.findById(id);
        return clientEntity.isPresent() ? Optional.of(clientMapper.toData(clientEntity.get())) :
               Optional.empty();
    }


}
