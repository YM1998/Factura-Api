package co.com.system.invoice.persistence.attribute;

import org.mapstruct.Mapper;

import co.com.system.invoice.model.Attribute;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AttributeMapper{

    @Mapping(target = "idAttribute", source = "input.id")
    public Attribute toData(AttributeEntity input);

}
