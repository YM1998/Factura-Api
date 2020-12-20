package co.com.system.invoice.translators;

import java.text.ParseException;

import org.springframework.stereotype.Component;

import co.com.system.invoice.constants.DateFormats;
import co.com.system.invoice.domain.CategoryDTO;
import co.com.system.invoice.persistence.entity.Category;
import co.com.system.invoice.persistence.entity.State;
import co.com.system.invoice.utils.DateUtils;

@Component
public class CategoryTranslator implements Translator<CategoryDTO, Category>{

    @Override
    public Category translate(CategoryDTO input) {
        try {
            return Category.builder()
                    .fechaCreacion(DateUtils.convertStringToDate(input.getCreationDate(), DateFormats.DD_MM_YYYY.getValue()))
                    .fechaModificacion(DateUtils.convertStringToDate(input.getModificationDate(), DateFormats.DD_MM_YYYY.getValue()))
                    .idCategoria(input.getIdCategory())
                    .estado(State.builder().idEstado(input.getIdStatus()).build())
                    .nombre(input.getName())
                    .userCreacion(input.getCreationUser())
                    .userModificacion(input.getModificationUser())
                    .build();
        } catch (ParseException e) {
           return null;
        }
    }

}
