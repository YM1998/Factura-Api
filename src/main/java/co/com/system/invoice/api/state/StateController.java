package co.com.system.invoice.api.state;

import java.util.List;

import co.com.system.invoice.service.state.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.system.invoice.model.State;

/**@author Yesid
 */
@RestController
@RequestMapping(value = "/state")
public class StateController implements  IStateController{

    @Autowired private StateService stateService;

    @GetMapping(value = "/getAll")
    public List<State> getAll(){
         return stateService.findAll();
    }

}
