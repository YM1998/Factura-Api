package co.com.system.invoice.service.category;

import co.com.system.invoice.constants.CodeExceptions;
import co.com.system.invoice.exception.AppException;
import co.com.system.invoice.model.Category;
import co.com.system.invoice.persistence.category.CategoryDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateCategoryService {

    @Autowired private CategoryDataProvider categoryDataProvider;


    @Transactional
    public void update(Category category) throws AppException {
        Category categoryPersist = categoryDataProvider.findById(category.getIdCategory());
        if(categoryPersist == null)  throw new AppException(CodeExceptions.CATEGORY_NOT_EXIST);

        categoryPersist.setName(category.getName());
        categoryPersist.setIdStatus(category.getIdStatus());
        categoryPersist.setModificationUser(category.getCreationUser());
        validateName(categoryPersist);
        categoryDataProvider.save(categoryPersist);
    }



    @Transactional
    public void updateStatus(Category category) throws AppException {
        Category categoryPersist = categoryDataProvider.findById(category.getIdCategory());
        if(categoryPersist == null)  throw new AppException(CodeExceptions.CATEGORY_NOT_EXIST);

        categoryPersist.setName(category.getName());
        categoryPersist.setIdStatus(category.getIdStatus());
        categoryPersist.setModificationUser(category.getCreationUser());
        validateName(categoryPersist);
        categoryDataProvider.save(categoryPersist);
    }

    private void validateName(final Category category) throws AppException{
        if(categoryDataProvider.existNameForOtherRecords(category.getName(), category.getIdCategory()))
            throw new AppException(CodeExceptions.NAME_EXIST);
    }
}
