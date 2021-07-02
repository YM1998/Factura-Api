package co.com.system.invoice.service.interfaces;

import java.util.List;

import co.com.system.invoice.domain.CategoryDTO;
import co.com.system.invoice.exception.AppException;

/**
 * The Interface ICategoryService.
 * @author yesid*
 */
public interface ICategoryService {

    /**
     * Save.
     * @param category the category
     * @return the category DTO
     * @throws AppException the app exception
     */
    public void save(CategoryDTO category)throws AppException;

    /**
     * Find all.
     * @return the list
     */
    public List<CategoryDTO> findAll() ;

    /**
     * Delete.
     * @param idCategory the id category
     * @throws AppException the app exception
     */
    public void delete(final Long idCategory)throws AppException;

}
