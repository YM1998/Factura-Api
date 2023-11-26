package co.com.system.invoice.api.attribute;

import co.com.system.invoice.constants.GeneralConstans;
import co.com.system.invoice.constants.RolesEnum;
import co.com.system.invoice.model.Attribute;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public interface IAttributeController {

     final static String admin = "";

    @Secured(RolesEnum.ROLE_ADMIN)
    @GetMapping(value = "/getAll")
    public List<Attribute> getAll();
}
