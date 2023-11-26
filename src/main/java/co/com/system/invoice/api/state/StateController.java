package co.com.system.invoice.api.state;

import java.util.List;

import co.com.system.invoice.service.state.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.system.invoice.model.State;

/**@author Yesid
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/state")
public class StateController implements  IStateController{

    private final StateService stateService;

    @GetMapping(value = "/getAll")
    public List<State> getAll(){
         return stateService.findAll();
    }

}
