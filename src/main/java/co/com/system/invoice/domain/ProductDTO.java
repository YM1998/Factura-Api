package co.com.system.invoice.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import co.com.system.invoice.constants.DateFormats;
import co.com.system.invoice.utils.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class ProductDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	/**
	 * Costructor usado para query JPA
	 * @author Yesid Murillo
	 * @param idProduct
	 * @param inventoryQuantity
	 * @param description
	 * @param creationDate
	 * @param modificationDate
	 * @param name
	 * @param price
	 * @param userCreation
	 * @param userModification
	 * @param idCategory
	 * @param categoryName
	 * @param statusName
	 * @param statusId
	 * @param attributes
	 */
    public ProductDTO(Long idProduct, Integer inventoryQuantity,
            String description, Date creationDate, Date modificationDate,
            String name, Double price, String userCreation,
            String userModification, Long idCategory, String categoryName,
            String statusName, Long statusId, Long idAtributte, String nameAtributte,
            String valueAttribute, Double cost, Long idProductAttribute,
            String codigoProducto, Double iva) {
        super();
        this.idProduct = idProduct;
        this.inventoryQuantity = inventoryQuantity;
        this.description = description;
        this.creationDate = DateUtils.convertDateToString(creationDate, DateFormats.DD_MM_YYYY.getValue());
        this.modificationDate = DateUtils.convertDateToString(modificationDate, DateFormats.DD_MM_YYYY.getValue());
        this.name = name;
        this.price = price;
        this.cost = cost;
        this.userCreation = userCreation;
        this.userModification = userModification;
        this.idCategory = idCategory;
        this.categoryName = categoryName;
        this.statusName = statusName;
        this.statusId = statusId;
        this.codigo = codigoProducto;
        this.iva = iva;

        if(idAtributte!=null) {
            this.attribute = AttributeDTO.builder()
                            .idAttribute(idAtributte)
                            .idProductAttribute(idProductAttribute)
                            .name(nameAtributte)
                            .value(valueAttribute)
                            .build();
        }

    }


    public ProductDTO(Long idProduct, String codigo, Integer inventoryQuantity,
                      String description, String name, Double price) {
        super();
        this.idProduct = idProduct;
        this.codigo = codigo;
        this.inventoryQuantity = inventoryQuantity;
        this.description = description;
        this.name = name;
        this.price = price;
    }




    private Long idProduct;
    private String codigo;
	private Integer inventoryQuantity;
	private String description;
	private String creationDate;
	private String modificationDate;

	@NotBlank(message = "El campo nombre es obligatorio")
	private String name;

	@NotNull(message = "El campo precio es obligatorio")
	private Double price;

	@NotNull(message = "El campo costo es obligatorio")
    private Double cost;

	@NotNull(message = "El campo iva  es obligatorio")
    private Double iva;


	@NotBlank(message = "El campo usuario creacion es obligatorio")
	private String userCreation;

	@NotBlank(message = "El  campo usuario modificacion es obligatorio")
	private String userModification;

	@NotNull(message = "La categoria es obligatoria")
	private Long idCategory;

	private String categoryName;
	private String statusName;

	@NotNull(message = "El estado es obligatorio")
	private Long statusId;
	private List<AttributeDTO> attributes;
	private AttributeDTO attribute;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProductDTO other = (ProductDTO) obj;
        if (idProduct == null) {
            if (other.idProduct != null)
                return false;
        } else if (!idProduct.equals(other.idProduct))
            return false;
        return true;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((idProduct == null) ? 0 : idProduct.hashCode());
        return result;
    }





}