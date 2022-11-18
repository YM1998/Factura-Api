package co.com.system.invoice.persistence.state;

import co.com.system.invoice.model.State;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StateMapper {

    public State toData(StateEntity stateEntity);
}
