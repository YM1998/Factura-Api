package co.com.system.invoice.service.interfaces;

import java.util.List;

import co.com.system.invoice.domain.CategoryDTO;
import co.com.system.invoice.exception.AppException;

/**@author yesid*
 */
public interface ICategoryService {

    public CategoryDTO save(CategoryDTO category)throws AppException;

    public List<CategoryDTO> findAll() ;

    public void delete(final Long idCategory)throws AppException;

}
