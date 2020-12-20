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
import co.com.system.invoice.persistence.dataproviders.interfaces.ICategoryDataProvider;
import co.com.system.invoice.service.interfaces.ICategoryService;
import co.com.system.invoice.service.interfaces.IProductService;
import co.com.system.invoice.utils.DateUtils;

@Service
public class CategoryService implements ICategoryService{

    @Autowired
    private ICategoryDataProvider categoryDataProvider;

    @Autowired
    private IProductService productService;

    @Override
    @Transactional(rollbackFor  = Exception.class)
    public CategoryDTO save(final CategoryDTO category) throws AppException{
        validateName(category);

        if(category.getIdCategory() == null)
           category.setCreationDate(DateUtils.convertDateToString(new Date(), DateFormats.DD_MM_YYYY.getValue()));

        category.setModificationDate(DateUtils.convertDateToString(new Date(), DateFormats.DD_MM_YYYY.getValue()));
        return categoryDataProvider.save(category);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll(){
        return categoryDataProvider.findAll();
    }


    @Override
    @Transactional(rollbackFor  = Exception.class)
    public void delete(final Long idCategory) throws AppException{
        Long countProducts = productService.countByIdCategoria(idCategory);
        if(countProducts!=null && countProducts.compareTo(0L)>0)
            throw new AppException(CodeExceptions.CATEGORY_CANNOT_BE_DELETED);

        categoryDataProvider.delete(idCategory);
    }

    private void validateName(final CategoryDTO category) throws AppException{
        if(category.getIdCategory()==null &&
          categoryDataProvider.existName(category.getName()))
          throw new AppException(CodeExceptions.NAME_EXIST);

        if(category.getIdCategory()!=null &&
           categoryDataProvider.existNameForOtherRecords(category.getName(),
                                                         category.getIdCategory()))
           throw new AppException(CodeExceptions.NAME_EXIST);
    }

}
