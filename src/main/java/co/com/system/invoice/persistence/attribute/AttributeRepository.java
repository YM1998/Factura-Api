package co.com.system.invoice.persistence.attribute;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AttributeRepository extends JpaRepository<AttributeEntity, Integer> {

   @Query("select a from AttributeEntity a order by a.name asc")
    public List<AttributeEntity> findAllOrderByName();
}
