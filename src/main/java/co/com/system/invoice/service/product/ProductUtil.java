package co.com.system.invoice.service.product;

import co.com.system.invoice.constants.CodeExceptions;
import co.com.system.invoice.exception.AppException;
import co.com.system.invoice.model.Attribute;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductUtil {


    public void validateAttributeNotDuplicates(List<Attribute> attributes) throws AppException {
        if(attributes == null || attributes.isEmpty()) return;

        Boolean attributesAreDuplicate = attributes.stream()
                .collect(Collectors.groupingBy(Attribute::getIdAttribute))
                .entrySet()
                .stream()
                .anyMatch(v -> v.getValue().size()>1);

        if(attributesAreDuplicate) throw new AppException(CodeExceptions.PRODUCT_ATTRIBUTES_DUPLICATES);

    }

}
