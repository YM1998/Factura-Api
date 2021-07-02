package co.com.system.invoice.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.system.invoice.domain.StateDTO;
import co.com.system.invoice.service.interfaces.IStateService;

/**@author Yesid
 */
@RestController
@RequestMapping(value = "/state")
public class StateController {

    @Autowired private IStateService stateService;

    @GetMapping(value = "/getAll")
    public List<StateDTO> getAll(){
         return stateService.findAll();
    }

}
