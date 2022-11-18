package co.com.system.invoice.service.state;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.system.invoice.model.State;
import co.com.system.invoice.persistence.state.StateDataProvider;

@Service
public class StateService {

    @Autowired private StateDataProvider stateDataProvider;

    @Transactional(readOnly = true)
    public List<State> findAll() {
        return stateDataProvider.findAll();
    }

}
