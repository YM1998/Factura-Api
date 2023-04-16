package co.com.system.invoice.api.state;

import co.com.system.invoice.model.State;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface IStateController {

    @GetMapping(value = "/getAll")
    public List<State> getAll();

}
