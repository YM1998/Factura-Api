package co.com.system.invoice.persistence.client;

import co.com.system.invoice.model.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@RequiredArgsConstructor
@Repository
public class ClientDataProvider {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public Optional<Client> findById(Long id) {
        Optional<ClientEntity> clientEntity = clientRepository.findById(id);
        return clientEntity.isPresent() ? Optional.of(clientMapper.toData(clientEntity.get())) :
               Optional.empty();
    }


}
