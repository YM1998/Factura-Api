package co.com.system.invoice.api.payment.type;

import co.com.system.invoice.constants.RolesEnum;
import co.com.system.invoice.model.PaymentType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface IPaymentTypeController {


    @Secured({RolesEnum.ROLE_ADMIN, RolesEnum.ROLE_SELLER})
    @GetMapping(value = "/getAll")
    public List<PaymentType> getAll();


}
