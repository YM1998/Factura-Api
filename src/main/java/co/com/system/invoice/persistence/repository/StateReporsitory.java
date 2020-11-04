package co.com.system.invoice.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.system.invoice.persistence.entity.State;

public interface StateReporsitory extends JpaRepository<State, Long>{

}
