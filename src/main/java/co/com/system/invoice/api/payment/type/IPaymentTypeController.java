package co.com.system.invoice.api.payment.type;

import co.com.system.invoice.model.PaymentType;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface IPaymentTypeController {


    @GetMapping(value = "/getAll")
    public List<PaymentType> getAll();


}
