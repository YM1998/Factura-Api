package co.com.system.invoice.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.com.system.invoice.domain.StateDTO;
import co.com.system.invoice.persistence.entity.State;

public interface StateReporsitory extends JpaRepository<State, Long>{

    @Query(value = "select new co.com.system.invoice.domain.StateDTO(s.idEstado,s.nombre) "
            + "from State s")
    public List<StateDTO> findAllState();

}
