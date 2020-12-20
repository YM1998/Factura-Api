package co.com.system.invoice.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.com.system.invoice.persistence.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

    @Query("select count(p) from Product p where p.categoria.idCategoria=?1 ")
    public Long countByIdCategoria(Long idCategoria);

}
