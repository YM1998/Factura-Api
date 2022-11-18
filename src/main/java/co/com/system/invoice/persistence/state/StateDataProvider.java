package co.com.system.invoice.persistence.state;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.system.invoice.model.State;

@Repository
public class StateDataProvider {

    @Autowired private StateRepository stateRepository;
    @Autowired private StateMapper stateMapper;

    public List<State> findAll() {
        return stateRepository.findAll().stream().map(stateMapper::toData).collect(Collectors.toList());
    }

}
