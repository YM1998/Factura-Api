package co.com.system.invoice.persistence.dataproviders.interfaces;

import java.util.List;

import co.com.system.invoice.domain.CategoryDTO;

/**@author Yesid
 */
public interface ICategoryDataProvider {

    public CategoryDTO save(final CategoryDTO category) throws Exception;

    public CategoryDTO findById(final Long id) throws Exception;

    public List<CategoryDTO> findAll() throws Exception;

    public boolean  existName(final String name) throws Exception;

    public boolean existNameForOtherRecords(final String name, final Long id) throws Exception;


}
