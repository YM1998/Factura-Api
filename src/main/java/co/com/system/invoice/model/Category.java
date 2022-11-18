package co.com.system.invoice.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import co.com.system.invoice.constants.DateFormats;
import co.com.system.invoice.utils.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category implements Serializable{


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
    public Category(Long idCategory, String name, Long idStatus,
                    String status, LocalDate creationDate, LocalDate modificationDate,
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

    @NotNull(message = "Ingrese el nombre")
    @NotBlank(message = "Ingrese el nombre")
    private String name;

    @NotNull(message = "Ingrese el nombre")
    private Long idStatus;
    private String status;
    private String creationDate;
    private String modificationDate;
    private String creationUser;
    private String modificationUser;

}
