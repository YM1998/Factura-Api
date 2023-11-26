package co.com.system.invoice.service.attribute;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.system.invoice.model.Attribute;
import co.com.system.invoice.persistence.attribute.AttributeDataProvider;

@RequiredArgsConstructor
@Service
public class AttributeService {

    private final AttributeDataProvider attributeDataProvider;


    @Transactional(readOnly = true)
    public List<Attribute> findAll() {
        return attributeDataProvider.findAll();
    }

}
