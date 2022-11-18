package co.com.system.invoice.persistence.attribute;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.system.invoice.model.Attribute;

@Repository
public class AttributeDataProvider {

    @Autowired private AttributeRepository attributeRepository;
    @Autowired private AttributeMapper attributeMapper;


    public List<Attribute> findAll() {
        return attributeRepository.findAllOrderByName()
                                   .stream()
                                   .map(attributeMapper::toData)
                                   .collect(Collectors.toList());
    }
}
