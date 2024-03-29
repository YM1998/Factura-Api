package co.com.system.invoice.persistence.product;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.system.invoice.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import co.com.system.invoice.constants.GeneralConstans;
import co.com.system.invoice.model.ProductFilter;

@RequiredArgsConstructor
@Repository
public class CustomProductRepositoryImpl implements CustomProductRepository{

    private final EntityManager entityManager;

    @Override
    public List<ProductEntity> findByCriteria(final ProductFilter productFilter) {
        Query query = entityManager.createQuery(getQueryFindByCriteria(productFilter));

        if(productFilter.isCategory())
           query.setParameter("idCategory", productFilter.getIdCategory());

        if(productFilter.isStatus())
           query.setParameter("idStatus", productFilter.getIdStatus());


        return query.getResultList();
    }

    @Override
    public List<Product> findByProductWithStockBySellingPoint(Integer sellingPointId) {

        String sql = "select  p.id, p.code, p.name, p.state_id, stk.stock inventoryQuantity " +
                "from product p " +
                "left join (select * from selling_points_product_stock spps where spps.selling_point_id =:sellingPointId) stk on stk.product_id = p.id " +
                "order by p.id ";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("sellingPointId", sellingPointId);

        List<Object[]> productList = query.getResultList();
        return productList
                .stream()
                .map(objects ->
                    Product.builder()
                           .idProduct(((Integer)objects[0]).longValue())
                           .codigo((String)objects[1])
                           .name((String)objects[2])
                           .statusId(((Integer)objects[3]).longValue())
                           .inventoryQuantity(objects[4]!=null? (Integer)objects[4]: null)
                           .build()
                ).collect(Collectors.toList());
    }


    private String getQueryFindByCriteria(final ProductFilter productFilter) {
        StringBuilder query = new StringBuilder();
        query.append("select p from Product where 1 = 1");

        if(productFilter.isCategory())
           query.append(" and p.category.id=:idCategory");

        if(productFilter.isStatus())
            query.append(" and p.state.id=:idStatus");

        if(productFilter.islowInventory()) {
            query.append(" and p.inventoryQuantity<=".concat(GeneralConstans.AMOUNT_LOW_INVENTORY.toString()));
        }else if(productFilter.isStableInventory()) {
            query.append(" and p.inventoryQuantity<=".concat(GeneralConstans.AMOUNT_STABLE_INVENTORY.toString()));
        }else if(productFilter.isExceededInventory()) {
            query.append(" and p.inventoryQuantity>".concat(GeneralConstans.AMOUNT_STABLE_INVENTORY.toString()));
        }

        return query.toString();
    }


}
