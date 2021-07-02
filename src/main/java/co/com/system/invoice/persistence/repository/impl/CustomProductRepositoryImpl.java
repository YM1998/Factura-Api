package co.com.system.invoice.persistence.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.system.invoice.constants.GeneralConstans;
import co.com.system.invoice.domain.ProductFilter;
import co.com.system.invoice.persistence.entity.Product;
import co.com.system.invoice.persistence.repository.CustomProductRepository;

@Repository
public class CustomProductRepositoryImpl implements CustomProductRepository{

    @Autowired private EntityManager entityManager;

    @Override
    public List<Product> findByCriteria(final ProductFilter productFilter) {
        Query query = entityManager.createQuery(getQueryFindByCriteria(productFilter));

        if(productFilter.isCategory())
           query.setParameter("idCategory", productFilter.getIdCategory());

        if(productFilter.isStatus())
           query.setParameter("idStatus", productFilter.getIdStatus());


        return query.getResultList();
    }


    private String getQueryFindByCriteria(final ProductFilter productFilter) {
        StringBuilder query = new StringBuilder();
        query.append("select p from Product where 1 = 1");

        if(productFilter.isCategory())
           query.append(" and p.categoria.idCategoria=:idCategory");

        if(productFilter.isStatus())
            query.append(" and p.estado.idEstado=:idStatus");

        if(productFilter.islowInventory()) {
            query.append(" and p.cantidadInventario<=".concat(GeneralConstans.AMOUNT_LOW_INVENTORY.toString()));
        }else if(productFilter.isStableInventory()) {
            query.append(" and p.cantidadInventario<=".concat(GeneralConstans.AMOUNT_STABLE_INVENTORY.toString()));
        }else if(productFilter.isExceededInventory()) {
            query.append(" and p.cantidadInventario>".concat(GeneralConstans.AMOUNT_STABLE_INVENTORY.toString()));
        }

        return query.toString();
    }


}
