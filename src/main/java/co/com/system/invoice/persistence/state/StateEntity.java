package co.com.system.invoice.persistence.state;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import co.com.system.invoice.persistence.category.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the "Estados" database table.
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="state")
public class StateEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	private Long id;

	@Column
	private String name;

	@OneToMany(mappedBy="state")
	private List<CategoryEntity> categories;
}