package co.com.system.invoice.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.system.invoice.constants.CodeExceptions;
import co.com.system.invoice.constants.DateFormats;
import co.com.system.invoice.domain.CategoryDTO;
import co.com.system.invoice.exception.AppException;
import co.com.system.invoice.persistence.dataproviders.CategoryDataProvider;
import co.com.system.invoice.service.interfaces.ICategoryService;
import co.com.system.invoice.service.interfaces.IProductService;
import co.com.system.invoice.utils.DateUtils;

/**
 * @author Yesid Murillo Segura
 */
@Service
public class CategoryService implements ICategoryService{

    @Autowired private IProductService productService;
    @Autowired private CategoryDataProvider categoryDataProvider;

    @Override
    @Transactional
    public void save(final CategoryDTO category) throws AppException{
        validateName(category);
        setDate(category);
        categoryDataProvider.save(category);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll(){
        return categoryDataProvider.findAll();
    }


    @Override
    @Transactional
    public void delete(final Long idCategory) throws AppException{
        validateDelete(idCategory);
        categoryDataProvider.delete(idCategory);
    }

    private void validateDelete(final Long idCategory) throws AppException {
        Long countProducts = productService.countByIdCategoria(idCategory);
        if(countProducts!=null && countProducts.compareTo(0L)>0)
            throw new AppException(CodeExceptions.CATEGORY_CANNOT_BE_DELETED);
    }

    private void setDate(CategoryDTO category) {
        if(category.getIdCategory() == null)
           category.setCreationDate(DateUtils.convertDateToString(new Date(), DateFormats.DD_MM_YYYY.getValue()));

         category.setModificationDate(DateUtils.convertDateToString(new Date(), DateFormats.DD_MM_YYYY.getValue()));
    }


    private void validateName(final CategoryDTO category) throws AppException{
        if(category.getIdCategory()==null && categoryDataProvider.existName(category.getName()))
          throw new AppException(CodeExceptions.NAME_EXIST);

        if(category.getIdCategory()!=null && categoryDataProvider.existNameForOtherRecords(category.getName(), category.getIdCategory()))
           throw new AppException(CodeExceptions.NAME_EXIST);
    }
}
