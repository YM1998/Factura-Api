package co.com.system.invoice.service.person;

import co.com.system.invoice.model.Person;
import co.com.system.invoice.persistence.person.PersonDataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    @Autowired private PersonDataProvider personDataProvider;


    public Optional<Person> findById(Long id) {
        return personDataProvider.findById(id);
    }
}
