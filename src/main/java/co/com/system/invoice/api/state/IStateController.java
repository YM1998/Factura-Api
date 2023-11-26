package co.com.system.invoice.api.state;

import co.com.system.invoice.constants.RolesEnum;
import co.com.system.invoice.model.State;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface IStateController {

    @Secured({RolesEnum.ROLE_ADMIN})
    @GetMapping(value = "/getAll")
    public List<State> getAll();

}
