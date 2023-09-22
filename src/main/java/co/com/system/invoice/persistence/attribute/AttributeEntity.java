package co.com.system.invoice.persistence.attribute;

import java.io.Serializable;

import javax.persistence.*;

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
@Table(name="attribute")
public class AttributeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	private Long id;

	@Column
	private String name;


}