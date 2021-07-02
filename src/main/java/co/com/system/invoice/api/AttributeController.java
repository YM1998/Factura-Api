package co.com.system.invoice.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.system.invoice.domain.AttributeDTO;
import co.com.system.invoice.service.interfaces.IAttributeService;

/**@author Yesid
 */
@SpringBootApplication
@RestController
@RequestMapping(value = "/attribute")
public class AttributeController {


    @Autowired private IAttributeService attributeService;


    @GetMapping(value = "/getAll")
    public List<AttributeDTO> getAll(){
         return attributeService.findAll();
    }

}
