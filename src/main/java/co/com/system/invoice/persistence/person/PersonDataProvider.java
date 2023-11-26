package co.com.system.invoice.persistence.person;

import co.com.system.invoice.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class PersonDataProvider {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;


    public Optional<Person>  findById(Long id) {
        Optional<PersonEntity> personEntity = personRepository.findById(id);
        return personEntity.isPresent() ? Optional.of(personMapper.toData(personEntity.get())):Optional.empty();
    }
}
