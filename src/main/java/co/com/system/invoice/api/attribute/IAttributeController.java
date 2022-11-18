package co.com.system.invoice.api.attribute;

import co.com.system.invoice.model.Attribute;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping(value = "/attribute")
public interface IAttributeController {

    @GetMapping(value = "/getAll")
    public List<Attribute> getAll();
}
