package co.com.system.invoice.translators;

import org.springframework.stereotype.Component;

import co.com.system.invoice.constants.DateFormats;
import co.com.system.invoice.domain.CategoryDTO;
import co.com.system.invoice.persistence.entity.Category;
import co.com.system.invoice.utils.DateUtils;


@Component
public class CategoryDTOTranslator implements Translator<Category, CategoryDTO>{

    @Override
    public CategoryDTO translate(Category input) {
        return CategoryDTO.builder()
                          .creationDate(DateUtils.convertDateToString(input.getFechaCreacion(), DateFormats.DD_MM_YYYY.getValue()))
                          .creationUser(input.getUserCreacion())
                          .idCategory(input.getIdCategoria())
                          .modificationDate(DateUtils.convertDateToString(input.getFechaModificacion(), DateFormats.DD_MM_YYYY.getValue()))
                          .modificationUser(input.getUserModificacion())
                          .name(input.getNombre())
                          .status(input.getEstado()!=null? input.getEstado().getNombre(): null)
                          .idStatus(input.getEstado()!=null? input.getEstado().getIdEstado(): null)
                          .build();
    }

}
