package co.com.system.invoice.persistence.product;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import co.com.system.invoice.persistence.category.CategoryEntity;
import co.com.system.invoice.persistence.product.attribute.ProductAttributeEntity;
import co.com.system.invoice.persistence.sellingpoint.SellingPointEntity;
import co.com.system.invoice.persistence.state.StateEntity;
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
@Table(name="product")
public class ProductEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Long id;
	@Column private String code;
	@Column private String description;
	@Column private LocalDate createdAt;
	@Column(name = "update_date")
	private LocalDate update;
	@Column private String name;
	@Column private Double price;
	@Column private Double cost;
	@Column private Double iva;
	@Column private String creationUser;
	@Column private String modificationUser;

	@ManyToOne
	@JoinColumn(name="category_id")
	private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name="state_id")
    private StateEntity state;

	@OneToMany(mappedBy="product", cascade = CascadeType.ALL)
	private List<ProductAttributeEntity> attributeProducts;

	@Transient
	private Integer inventoryQuantity;


	@PrePersist
	public void prePersist() {
		this.update = LocalDate.now();
	}


	public boolean attributesIsEmpty() {
        return !attributesNotEmpty();
 }

	 public boolean attributesNotEmpty() {
	        return this.attributeProducts != null && !this.attributeProducts.isEmpty();
	 }

}