package co.com.system.invoice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.system.invoice.constants.CodeExceptions;
import co.com.system.invoice.domain.CategoryDTO;
import co.com.system.invoice.exception.AppException;
import co.com.system.invoice.persistence.dataproviders.interfaces.ICategoryDataProvider;
import co.com.system.invoice.service.interfaces.ICategoryService;

@Service
public class CategoryService implements ICategoryService{

    @Autowired
    private ICategoryDataProvider categoryDataProvider;

    @Override
    @Transactional(rollbackFor  = Exception.class)
    public CategoryDTO save(final CategoryDTO category) throws Exception {
        validateName(category);
        return categoryDataProvider.save(category);
    }

    @Override
    @Transactional(readOnly = true)
    public CategoryDTO findById(Long id) throws Exception {
        return categoryDataProvider.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() throws Exception {
        return categoryDataProvider.findAll();
    }

    private void validateName(final CategoryDTO category)throws Exception{
        if(category.getIdCategory()==null && categoryDataProvider.existName(category.getName())) {
            throw new AppException(CodeExceptions.NAME_EXIST);
        }
        if(category.getIdCategory()!=null &&
           categoryDataProvider.existNameForOtherRecords(category.getName(), category.getIdCategory())) {
            throw new AppException(CodeExceptions.NAME_EXIST);
        }
    }

}
