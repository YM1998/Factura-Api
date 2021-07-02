package co.com.system.invoice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.system.invoice.domain.AttributeDTO;
import co.com.system.invoice.persistence.dataproviders.AttributeDataProvider;
import co.com.system.invoice.service.interfaces.IAttributeService;

@Service
public class AttributeService implements IAttributeService{

    @Autowired private AttributeDataProvider attributeDataProvider;


    @Override
    @Transactional(readOnly = true)
    public List<AttributeDTO> findAll() {
        return attributeDataProvider.findAll();
    }

}
