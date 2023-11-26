package co.com.system.invoice.service.payment.type;

import co.com.system.invoice.model.PaymentType;
import co.com.system.invoice.persistence.payment.type.PaymentTypeDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PaymentTypeService {

    private final PaymentTypeDataProvider paymentTypeDataProvider;



    public List<PaymentType> findAll() {
        return paymentTypeDataProvider.findAll();
    }

    public Optional<PaymentType> findById(Integer paymentTypeId) {
        return paymentTypeDataProvider.findById(paymentTypeId);
    }


}
