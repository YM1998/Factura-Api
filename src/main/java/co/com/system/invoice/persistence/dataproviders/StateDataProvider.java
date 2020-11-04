package co.com.system.invoice.persistence.dataproviders;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import co.com.system.invoice.domain.StateDTO;
import co.com.system.invoice.persistence.dataproviders.interfaces.IStateDataProvider;
import co.com.system.invoice.persistence.entity.State;
import co.com.system.invoice.persistence.repository.StateReporsitory;
import co.com.system.invoice.translators.Translator;

@Component
public class StateDataProvider implements IStateDataProvider{

    @Autowired
    private StateReporsitory stateReporsitory;

    @Autowired
    @Qualifier("stateDTOTranslator")
    private Translator<State, StateDTO> stateDTOTranslator;


    @Override
    public List<StateDTO> findAll() {
        List<State> list = stateReporsitory.findAll();
        return list.stream()
                   .map(stateDTOTranslator::translate)
                   .collect(Collectors.toList());
    }

}
