package co.com.system.invoice.api.payment.type;

import co.com.system.invoice.model.PaymentType;
import co.com.system.invoice.service.payment.type.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/payment-type")
public class PaymentTypeController implements  IPaymentTypeController{

    @Autowired private PaymentTypeService paymentTypeService;


    @Override
    public List<PaymentType> getAll() {
        return paymentTypeService.findAll();
    }
}
