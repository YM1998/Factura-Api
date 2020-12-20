package co.com.system.invoice.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the productos_atributos database table.
 *
 */
@Entity
@Table(name="productos_atributos")
public class ProductAtribute implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_producto_atributo")
	private Integer idProductoAtributo;

	private String valor;

	//bi-directional many-to-one association to Atributo
	@ManyToOne
	@JoinColumn(name="id_atributo")
	private Attribute atributo;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="id_producto")
	private Product producto;

	public ProductAtribute() {
	}

	public Integer getIdProductoAtributo() {
		return this.idProductoAtributo;
	}

	public void setIdProductoAtributo(Integer idProductoAtributo) {
		this.idProductoAtributo = idProductoAtributo;
	}

	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Attribute getAtributo() {
		return this.atributo;
	}

	public void setAtributo(Attribute atributo) {
		this.atributo = atributo;
	}

	public Product getProducto() {
		return this.producto;
	}

	public void setProducto(Product producto) {
		this.producto = producto;
	}

}