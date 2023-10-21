package co.com.system.invoice.persistence.product.stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductStockEntityRepository extends JpaRepository<ProductStockEntity, Long> {


    public List<ProductStockEntity> findBySellingPointId(Integer sellingPointId);

    @Modifying
    @Query("update ProductStockEntity p set p.stock = p.stock + :amount  where p.productId = :id and " +
            "p.sellingPointId =:sellingPointId")
    public void updateQuantityInventoryByOperation(@Param("id") Long id, @Param("amount") Integer amount,
                                                   @Param("sellingPointId") Integer sellingPointId);

    @Modifying
    @Query("update ProductStockEntity p set p.stock = :inventoryQuantity  where p.id = :id and" +
            " p.sellingPointId =:sellingPointId")
    public void updateQuantityInventory(@Param("id") Long id, @Param("inventoryQuantity") Integer inventoryQuantity,
                                        @Param("sellingPointId") Integer sellingPointId);


    @Query("select p from ProductStockEntity p where p.sellingPointId=:sellingPointId and p.productId =:productId ")
    public ProductStockEntity findByProduct(@Param("productId") Long productId, @Param("sellingPointId")Integer sellingPointId);



}
