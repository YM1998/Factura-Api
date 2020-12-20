package co.com.system.invoice.domain;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idProduct;
	private Integer inventoryQuantity;
	private String description;
	private String creationDate;
	private String modificationDate;
	private String name;
	private Double price;
	private String userCreation;
	private String userModification;
	private Long idCategory;
	private String categoryName;
	private List<AttributeDTO> attributes;

}