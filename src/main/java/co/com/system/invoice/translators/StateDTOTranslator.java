package co.com.system.invoice.translators;

import org.springframework.stereotype.Component;

import co.com.system.invoice.domain.StateDTO;
import co.com.system.invoice.persistence.entity.State;

@Component
public class StateDTOTranslator implements Translator<State, StateDTO>{

    @Override
    public StateDTO translate(State input) {
        return StateDTO.builder().id(input.getIdEstado()).name(input.getNombre()).build();
    }

}
