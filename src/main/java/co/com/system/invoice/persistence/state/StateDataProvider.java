package co.com.system.invoice.persistence.state;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.system.invoice.model.State;

@RequiredArgsConstructor
@Repository
public class StateDataProvider {

    private final StateRepository stateRepository;
    private final StateMapper stateMapper;

    public List<State> findAll() {
        return stateRepository.findAll().stream().map(stateMapper::toData).collect(Collectors.toList());
    }

}
