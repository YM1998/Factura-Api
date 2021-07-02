package co.com.system.invoice.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.com.system.invoice.domain.ProductDTO;
import co.com.system.invoice.persistence.entity.Product;

public interface ProductRepository extends  JpaRepository<Product, Long>{

    @Query("select count(p) from Product p where p.categoria.idCategoria=?1 ")
    public Long countByIdCategoria(Long idCategoria);

    @Query("select new co.com.system.invoice.domain.ProductDTO(p.idProducto,p.cantidadInventario,p.descripcion,p.fechaCreacion"
            + ",p.fechaModificacion,p.nombre,p.precio,p.userCreacion,p.userModificacion,p.categoria.idCategoria,p.categoria.nombre,"
            + "p.estado.nombre,p.estado.idEstado, at.idAttribute, at.nombre, pa.valor, p.costo, pa.idProductoAtributo, p.codigo, p.iva) "
            + "from Product p "
            + "LEFT JOIN p.productosAtributos pa "
            + "LEFT JOIN pa.atributo at order by p.nombre,at.nombre ")
    public List<ProductDTO> findAllProducts();


    @Modifying
    @Query("delete from ProductAtribute pa where pa.idProductoAtributo  in (:list)")
    public void deleteAttributes(@Param("list") List<Long> list);

    @Query("select new co.com.system.invoice.domain.ProductDTO(p.idProducto, p.codigo, p.cantidadInventario, "
            + "p.descripcion, p.nombre, p.precio) "
         + "from Product p where p.codigo like '%:filter%' || p.nombre like '%:filter%'")
    public List<ProductDTO> findByNameOrCode(@Param("filter") String filter);


}
