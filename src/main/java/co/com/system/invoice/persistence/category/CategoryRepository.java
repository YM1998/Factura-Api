package co.com.system.invoice.persistence.category;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{

    public List<CategoryEntity> findByName(final String name);
    @Query("select c from CategoryEntity c  where name=?1 and id!=?2")
    public List<CategoryEntity>  findByNameForOtherRecords(final String name, final Long id);

    @Query("select c from CategoryEntity c  order by c.name asc")
    public List<CategoryEntity> findAllOrderByName();

}
