package co.com.system.invoice.persistence.person;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the personas database table.
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="person")
public class PersonEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	private Long id;
	private String name;
}