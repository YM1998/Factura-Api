package co.com.system.invoice.persistence.dataproviders.interfaces;

import java.util.List;

import co.com.system.invoice.domain.CategoryDTO;

/**@author Yesid
 */
public interface ICategoryDataProvider {

    public CategoryDTO save(final CategoryDTO category);


    public List<CategoryDTO> findAll();

    public boolean  existName(final String name);

    public boolean existNameForOtherRecords(final String name, final Long id);

    public void delete(final Long idCategory);


}
