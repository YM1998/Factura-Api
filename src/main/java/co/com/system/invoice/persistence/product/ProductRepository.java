package co.com.system.invoice.persistence.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.com.system.invoice.model.Product;

public interface ProductRepository extends  JpaRepository<ProductEntity, Long>{

    @Query("select count(p) from ProductEntity p where p.category.id=?1 ")
    public Long countByIdCategory(Long id);

    @Query("select new co.com.system.invoice.model.Product(p.id,p.inventoryQuantity,p.description,p.createdAt"
            + ",p.update,p.name,p.price,p.creationUser,p.modificationUser,p.category.id,p.category.name,"
            + "p.state.name,p.state.id, at.id, at.name, pa.value, p.cost, pa.id, p.code, p.iva) "
            + "from ProductEntity  p "
            + "LEFT JOIN p.attributeProducts pa "
            + "LEFT JOIN pa.attribute at order by p.name,at.name ")
    public List<Product> findAllProducts();


    @Modifying
    @Query("delete from ProductAttributeEntity pa where pa.id  in (:list)")
    public void deleteAttributes(@Param("list") List<Long> list);

    @Query("select new co.com.system.invoice.model.Product(p.id, p.code, p.inventoryQuantity, "
            + "p.description, p.name, p.price) "
         + "from ProductEntity p where p.code like '%:filter%' or p.name like '%:filter%'")
    public List<Product> findLikeByNameOrCode(@Param("filter") String filter);

    @Query("select p from ProductEntity p  where code=?1 and id!=?2")
    public List<ProductEntity>  findByCodeForOtherRecords(final String code, final Long id);

    public ProductEntity findByCode(final String code);


}
