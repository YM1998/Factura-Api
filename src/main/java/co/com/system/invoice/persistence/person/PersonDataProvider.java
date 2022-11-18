package co.com.system.invoice.persistence.person;

import co.com.system.invoice.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PersonDataProvider {

    @Autowired private PersonRepository personRepository;
    @Autowired private PersonMapper personMapper;


    public Optional<Person>  findById(Long id) {
        Optional<PersonEntity> personEntity = personRepository.findById(id);
        return personEntity.isPresent() ? Optional.of(personMapper.toData(personEntity.get())):Optional.empty();
    }
}
