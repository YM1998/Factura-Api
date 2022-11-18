package co.com.system.invoice.persistence.person;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository  extends JpaRepository<PersonEntity, Long> {
}
