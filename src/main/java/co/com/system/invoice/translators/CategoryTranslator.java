package co.com.system.invoice.translators;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

import co.com.system.invoice.constants.DateFormats;
import co.com.system.invoice.domain.CategoryDTO;
import co.com.system.invoice.persistence.entity.Category;
import co.com.system.invoice.persistence.entity.State;

@Component
public class CategoryTranslator implements Translator<CategoryDTO, Category>{

    @Override
    public Category translate(CategoryDTO input) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateFormats.DD_MM_YYYY.getValue());
        try {
            return Category.builder()
                    .fechaCreacion(simpleDateFormat.parse(input.getCreationDate()))
                    .fechaModificacion(simpleDateFormat.parse(input.getModificationDate()))
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
