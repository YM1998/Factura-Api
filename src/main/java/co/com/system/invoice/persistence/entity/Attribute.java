package co.com.system.invoice.persistence.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the atributos database table.
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name="atributos")
public class Attribute implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_atributo")
	private Long idAttribute;

	private String nombre;

	@OneToMany(mappedBy="atributo")
	private List<ProductAtribute> productosAtributos;


	public Attribute(Long idAttrbute) {
	    this.idAttribute = idAttrbute;
	}



	public ProductAtribute addProductosAtributo(ProductAtribute productosAtributo) {
		getProductosAtributos().add(productosAtributo);
		productosAtributo.setAtributo(this);

		return productosAtributo;
	}

	public ProductAtribute removeProductosAtributo(ProductAtribute productosAtributo) {
		getProductosAtributos().remove(productosAtributo);
		productosAtributo.setAtributo(null);

		return productosAtributo;
	}

}