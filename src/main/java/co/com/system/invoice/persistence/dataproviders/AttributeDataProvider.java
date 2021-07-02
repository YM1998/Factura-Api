package co.com.system.invoice.persistence.dataproviders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.system.invoice.domain.AttributeDTO;
import co.com.system.invoice.persistence.repository.AttributeRepository;

@Repository
public class AttributeDataProvider {

    @Autowired private AttributeRepository attributeRepository;


    public List<AttributeDTO> findAll() {
        return attributeRepository.findAllAttribute();
    }
}
