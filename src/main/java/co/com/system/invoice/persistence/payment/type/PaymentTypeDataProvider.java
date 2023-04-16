package co.com.system.invoice.persistence.payment.type;

import co.com.system.invoice.model.Attribute;
import co.com.system.invoice.model.PaymentType;
import co.com.system.invoice.persistence.attribute.AttributeMapper;
import co.com.system.invoice.persistence.attribute.AttributeRepository;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PaymentTypeDataProvider {


    @Autowired private PaymentTypeRepository paymentTypeRepository;
    @Autowired private PaymentTypeMapper paymentTypeMapper;


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
