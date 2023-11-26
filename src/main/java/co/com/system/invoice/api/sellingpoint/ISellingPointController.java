package co.com.system.invoice.api.sellingpoint;

import co.com.system.invoice.constants.RolesEnum;
import co.com.system.invoice.model.SellingPoint;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface ISellingPointController {


    @GetMapping(value = "/getAll")
    public  List<SellingPoint> getAll();

    @Secured({RolesEnum.ROLE_ADMIN, RolesEnum.ROLE_SELLER})
    @GetMapping(value = "/find/{id}")
    public Optional<SellingPoint> findById(@PathVariable("id") Integer id);



}
