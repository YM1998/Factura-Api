package co.com.system.invoice.persistence.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_producto")
	private Long idProducto;

	private String codigo;

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

	private Double precio;
	private Double costo;
	private Double iva;

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


	@OneToMany(mappedBy="producto", cascade = CascadeType.ALL)
	private List<ProductAtribute> productosAtributos;


	public void addProductosAtributo(ProductAtribute productosAtributo) {
	    if(this.productosAtributos == null)
	       this.productosAtributos = new ArrayList<>();

	    productosAtributo.setProducto(this);
	    this.productosAtributos.add(productosAtributo);

	}

	public ProductAtribute removeProductosAtributo(ProductAtribute productosAtributo) {
		getProductosAtributos().remove(productosAtributo);
		productosAtributo.setProducto(null);

		return productosAtributo;
	}

	public boolean attributesIsEmpty() {
        return !attributesNotEmpty();
 }

	 public boolean attributesNotEmpty() {
	        return this.productosAtributos != null && !this.productosAtributos.isEmpty();
	 }

}