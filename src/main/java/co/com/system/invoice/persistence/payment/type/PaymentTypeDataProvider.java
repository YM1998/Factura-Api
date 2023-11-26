package co.com.system.invoice.persistence.payment.type;

import co.com.system.invoice.model.PaymentType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class PaymentTypeDataProvider {


     private final PaymentTypeRepository paymentTypeRepository;
     private final PaymentTypeMapper paymentTypeMapper;


    public List<PaymentType> findAll() {
        return paymentTypeRepository.findAllByOrderByNameAsc()
                .stream()
                .map(paymentTypeMapper::toData)
                .collect(Collectors.toList());
    }

    public Optional<PaymentType> findById(Integer idPaymentType) {

        Optional<PaymentTypeEntity> paymentTypeEntityOption = paymentTypeRepository.findById(idPaymentType);
        return paymentTypeEntityOption.isPresent() ?
                Optional.of(paymentTypeMapper.toData(paymentTypeEntityOption.get())) : Optional.empty();
    }




}
