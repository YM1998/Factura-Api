package co.com.system.invoice.api.attribute;

import java.util.List;

import co.com.system.invoice.service.attribute.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.system.invoice.model.Attribute;

@SpringBootApplication
@RestController
@RequestMapping(value = "/attribute")
public class AttributeController implements  IAttributeController{


    @Autowired private AttributeService attributeService;


    @Override
    public List<Attribute> getAll(){
         return attributeService.findAll();
    }

}
