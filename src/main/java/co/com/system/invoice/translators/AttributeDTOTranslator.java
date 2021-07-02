package co.com.system.invoice.translators;

import org.springframework.stereotype.Component;

import co.com.system.invoice.domain.AttributeDTO;
import co.com.system.invoice.persistence.entity.Attribute;

@Component
public class AttributeDTOTranslator implements Translator<Attribute, AttributeDTO>{

    @Override
    public AttributeDTO translate(Attribute input) {
        return AttributeDTO.builder()
                           .idAttribute(input.getIdAttribute())
                           .name(input.getNombre()).build();
    }

}
