package co.com.system.invoice.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the productos database table.
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name="productos")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_producto")
	private Long idProducto;

	@Column(name="cantidad_inventario")
	private Integer cantidadInventario;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	private String nombre;

	private double precio;

	@Column(name="user_creacion")
	private String userCreacion;

	@Column(name="user_modificacion")
	private String userModificacion;

	@ManyToOne
	@JoinColumn(name="id_categoria")
	private Category categoria;

    @ManyToOne
    @JoinColumn(name="id_estado")
    private State estado;

	//bi-directional many-to-one association to ProductosAtributo
	@OneToMany(mappedBy="producto")
	private List<ProductAtribute> productosAtributos;


	public ProductAtribute addProductosAtributo(ProductAtribute productosAtributo) {
		getProductosAtributos().add(productosAtributo);
		productosAtributo.setProducto(this);

		return productosAtributo;
	}

	public ProductAtribute removeProductosAtributo(ProductAtribute productosAtributo) {
		getProductosAtributos().remove(productosAtributo);
		productosAtributo.setProducto(null);

		return productosAtributo;
	}

}