package co.com.system.invoice.service.person;

import co.com.system.invoice.model.Person;
import co.com.system.invoice.persistence.person.PersonDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class PersonService {

    private final PersonDataProvider personDataProvider;


    public Optional<Person> findById(Long id) {
        return personDataProvider.findById(id);
    }
}
