package co.com.system.invoice.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.com.system.invoice.domain.AttributeDTO;
import co.com.system.invoice.persistence.entity.Attribute;

public interface AttributeRepository extends JpaRepository<Attribute, Integer> {

    @Query(value = "select new co.com.system.invoice.domain.AttributeDTO(a.idAttribute,a.nombre) "
            +      "from Attribute a order by a.nombre")
    public List<AttributeDTO> findAllAttribute();
}
