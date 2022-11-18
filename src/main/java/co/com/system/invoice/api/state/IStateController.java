package co.com.system.invoice.api.state;

import co.com.system.invoice.model.State;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**@author Yesid
 */
@RestController
@RequestMapping(value = "/state")
public interface IStateController {

    @GetMapping(value = "/getAll")
    public List<State> getAll();

}
