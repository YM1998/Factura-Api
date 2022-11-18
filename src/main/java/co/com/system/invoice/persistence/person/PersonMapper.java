package co.com.system.invoice.persistence.person;

import co.com.system.invoice.model.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    public Person toData(PersonEntity personEntity);
    public PersonEntity toEntity(Person person);
}
