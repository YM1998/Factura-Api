package co.com.system.invoice.service.category;

import co.com.system.invoice.constants.CodeExceptions;
import co.com.system.invoice.constants.DateFormats;
import co.com.system.invoice.exception.AppException;
import co.com.system.invoice.model.Category;
import co.com.system.invoice.persistence.category.CategoryDataProvider;
import co.com.system.invoice.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class CreateCategoryService {

    @Autowired
    private CategoryDataProvider categoryDataProvider;

    @Transactional
    public void save(final Category category) throws AppException {
        validateName(category);
        category.setCreationDate(DateUtils.convertDateToString(LocalDate.now(), DateFormats.DD_MM_YYYY.getValue()));
        categoryDataProvider.save(category);
    }

    private void validateName(final Category category) throws AppException{
        if(categoryDataProvider.existName(category.getName()))
            throw new AppException(CodeExceptions.NAME_EXIST);
    }
}
