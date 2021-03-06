package co.com.system.invoice.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.com.system.invoice.domain.CategoryDTO;
import co.com.system.invoice.persistence.entity.Category;


public interface CategoryRepository extends JpaRepository<Category, Long>{

    @Query("select c from Category c  where nombre=?1 ")
    public List<Category> findByName(final String name);


    @Query("select c from Category c  where nombre=?1 and idCategoria!=?2")
    public List<Category>  findByNameForOtherRecords(final String name, final Long id);


    @Query("select new co.com.system.invoice.domain.CategoryDTO(c.idCategoria,c.nombre,c.estado.idEstado,c.estado.nombre,"
            + "c.fechaCreacion,c.fechaModificacion,c.userCreacion,c.userModificacion) from Category c order by c.nombre ")
    public List<CategoryDTO> findAllSortName();

}
