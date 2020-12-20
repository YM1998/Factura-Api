package co.com.system.invoice.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDTO implements Serializable{

    private static final long serialVersionUID = 1L;
    private Long idCategory;
    private String name;
    private Long idStatus;
    private String status;
    private String creationDate;
    private String modificationDate;
    private String creationUser;
    private String modificationUser;

}
