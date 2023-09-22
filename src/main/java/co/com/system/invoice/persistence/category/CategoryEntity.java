package co.com.system.invoice.persistence.category;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

import co.com.system.invoice.persistence.state.StateEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the "Categorias" database table.
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="category")
public class CategoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Long id;
	@Column  private LocalDate createAt;
	@Column private LocalDate update;
	@Column private String name;
	@Column
	private String creationUser;
	@Column private String modificationUser;

	@ManyToOne
    @JoinColumn(name="state_id")
    private StateEntity state;


	@PrePersist
	public void prePersist() {
		this.update = LocalDate.now();
	}

}