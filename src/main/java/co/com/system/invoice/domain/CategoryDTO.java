package co.com.system.invoice.domain;

import java.io.Serializable;
import java.util.Date;

import co.com.system.invoice.constants.DateFormats;
import co.com.system.invoice.utils.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDTO implements Serializable{


    /**
     * Costructor usado para consultas
     * @param idCategory
     * @param name
     * @param idStatus
     * @param status
     * @param creationDate
     * @param modificationDate
     * @param creationUser
     * @param modificationUser
     */
    public CategoryDTO(Long idCategory, String name, Long idStatus,
                       String status, Date creationDate, Date modificationDate,
                       String creationUser, String modificationUser) {
        super();
        this.idCategory = idCategory;
        this.name = name;
        this.idStatus = idStatus;
        this.status = status;
        this.creationDate = DateUtils.convertDateToString(creationDate, DateFormats.DD_MM_YYYY.getValue());
        this.modificationDate = DateUtils.convertDateToString(modificationDate, DateFormats.DD_MM_YYYY.getValue());;
        this.creationUser = creationUser;
        this.modificationUser = modificationUser;
    }


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
