package co.com.system.invoice.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the productos_atributos database table.
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="productos_atributos")
public class ProductAtribute implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_producto_atributo")
	private Long idProductoAtributo;

	private String valor;

	@ManyToOne
	@JoinColumn(name="id_atributo")
	private Attribute atributo;

	@ManyToOne
	@JoinColumn(name="id_producto")
	private Product producto;
}