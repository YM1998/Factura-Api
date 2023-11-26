package co.com.system.invoice.api.attribute;

import java.util.List;

import co.com.system.invoice.service.attribute.AttributeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.system.invoice.model.Attribute;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/attribute")
public class AttributeController implements  IAttributeController{


    private final AttributeService attributeService;


    @Override
    public List<Attribute> getAll(){
         return attributeService.findAll();
    }

}
