package co.com.system.invoice.persistence.payment.type;

import co.com.system.invoice.model.PaymentType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentTypeMapper {

    public PaymentType toData(PaymentTypeEntity paymentTypeEntity);

}
