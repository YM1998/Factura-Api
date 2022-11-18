package co.com.system.invoice.persistence.product.attribute;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import co.com.system.invoice.persistence.attribute.AttributeEntity;
import co.com.system.invoice.persistence.product.ProductEntity;
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
@Table(name="attribute_product")
public class ProductAttributeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id") private Long idProductAttribute;
	@Column private String value;

	@ManyToOne
	@JoinColumn(name="attribute_id")
	private AttributeEntity attribute;

	@ManyToOne
	@JoinColumn(name="product_id")
	private ProductEntity product;
}