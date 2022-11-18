package co.com.system.invoice.service.attribute;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.system.invoice.model.Attribute;
import co.com.system.invoice.persistence.attribute.AttributeDataProvider;

@Service
public class AttributeService {

    @Autowired private AttributeDataProvider attributeDataProvider;


    @Transactional(readOnly = true)
    public List<Attribute> findAll() {
        return attributeDataProvider.findAll();
    }

}
