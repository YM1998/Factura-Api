package co.com.system.invoice.persistence.entity;

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
@Table(name="personas")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_persona")
	private Integer idPersona;
	private String nombre;
}