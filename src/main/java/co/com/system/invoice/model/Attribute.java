package co.com.system.invoice.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Attribute implements Serializable {
	private static final long serialVersionUID = 1L;


    public Attribute(Long idAttribute, String name) {
        super();
        this.idAttribute = idAttribute;
        this.name = name;
    }

    private Long idAttribute;
    private Long idProductAttribute;
	private String name;
	private String value;

}