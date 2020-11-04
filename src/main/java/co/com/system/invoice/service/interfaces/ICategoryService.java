package co.com.system.invoice.service.interfaces;

import java.util.List;

import co.com.system.invoice.domain.CategoryDTO;

/**@author yesid*
 */
public interface ICategoryService {

    public CategoryDTO save(CategoryDTO category) throws Exception;

    public CategoryDTO findById(Long id) throws Exception;

    public List<CategoryDTO> findAll() throws Exception;

}
