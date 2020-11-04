package co.com.system.invoice.translators;

import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

import co.com.system.invoice.constants.DateFormats;
import co.com.system.invoice.domain.CategoryDTO;
import co.com.system.invoice.persistence.entity.Category;


@Component
public class CategoryDTOTranslator implements Translator<Category, CategoryDTO>{

    @Override
    public CategoryDTO translate(Category input) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateFormats.DD_MM_YYYY.getValue());
        return CategoryDTO.builder()
                          .creationDate(simpleDateFormat.format(input.getFechaCreacion()))
                          .creationUser(input.getUserCreacion())
                          .idCategory(input.getIdCategoria())
                          .modificationDate(simpleDateFormat.format(input.getFechaModificacion()))
                          .modificationUser(input.getUserModificacion())
                          .name(input.getNombre())
                          .status(input.getEstado()!=null? input.getEstado().getNombre(): null)
                          .idStatus(input.getEstado()!=null? input.getEstado().getIdEstado(): null)
                          .build();
    }

}
