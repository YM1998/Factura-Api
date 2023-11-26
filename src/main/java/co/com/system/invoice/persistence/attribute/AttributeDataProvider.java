package co.com.system.invoice.persistence.attribute;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import co.com.system.invoice.model.Attribute;

@RequiredArgsConstructor
@Repository
public class AttributeDataProvider {

    private final AttributeRepository attributeRepository;
    private final AttributeMapper attributeMapper;


    public List<Attribute> findAll() {
        return attributeRepository.findAllByOrderByNameAsc()
                                   .stream()
                                   .map(attributeMapper::toData)
                                   .collect(Collectors.toList());
    }
}
