package co.com.system.invoice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.system.invoice.domain.StateDTO;
import co.com.system.invoice.persistence.dataproviders.interfaces.IStateDataProvider;
import co.com.system.invoice.service.interfaces.IStateService;

@Service
public class StateService implements IStateService{

    @Autowired
    private IStateDataProvider stateDataProvider;

    @Override
    @Transactional(readOnly = true)
    public List<StateDTO> findAll() {
        return stateDataProvider.findAll();
    }

}
