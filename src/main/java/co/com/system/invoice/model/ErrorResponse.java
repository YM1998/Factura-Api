package co.com.system.invoice.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String codError;
    private String messageError;

}
