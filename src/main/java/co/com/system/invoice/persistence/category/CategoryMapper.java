package co.com.system.invoice.persistence.category;

import co.com.system.invoice.constants.DateFormats;
import co.com.system.invoice.model.Category;
import co.com.system.invoice.persistence.state.StateEntity;
import co.com.system.invoice.utils.DateUtils;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {


    public Category toData(CategoryEntity input) {
        return Category.builder()
                .creationDate(input.getCreateAt()!=null? DateUtils.convertDateToString(input.getCreateAt(), DateFormats.DD_MM_YYYY.getValue()): null)
                .creationUser(input.getCreationUser())
                .idCategory(input.getId())
                .modificationDate(input.getUpdate()!=null? DateUtils.convertDateToString(input.getUpdate(), DateFormats.DD_MM_YYYY.getValue()): null)
                .modificationUser(input.getModificationUser())
                .name(input.getName())
                .status(input.getState()!=null? input.getState().getName(): null)
                .idStatus(input.getState()!=null? input.getState().getId(): null)
                .build();
    }

    public CategoryEntity toEntity(Category input) {
        return CategoryEntity.builder()
                .createAt(DateUtils.convertStringToDate(input.getCreationDate(), DateFormats.DD_MM_YYYY.getValue()))
                .update(input.getModificationDate()!=null? DateUtils.convertStringToDate(input.getModificationDate(),
                        DateFormats.DD_MM_YYYY.getValue()): null)
                .id(input.getIdCategory())
                .state(StateEntity.builder().id(input.getIdStatus()).build())
                .name(input.getName())
                .creationUser(input.getCreationUser())
                .modificationUser(input.getModificationUser())
                .build();
    }

}
