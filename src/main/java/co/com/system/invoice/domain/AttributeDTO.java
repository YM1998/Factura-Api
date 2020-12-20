package co.com.system.invoice.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AttributeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer idAttribute;
	private String name;
	private String valor;

}