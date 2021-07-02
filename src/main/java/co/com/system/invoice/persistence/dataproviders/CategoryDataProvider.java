package co.com.system.invoice.persistence.dataproviders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import co.com.system.invoice.domain.CategoryDTO;
import co.com.system.invoice.persistence.entity.Category;
import co.com.system.invoice.persistence.repository.CategoryRepository;
import co.com.system.invoice.translators.Translator;

@Repository
public class CategoryDataProvider {


    @Autowired private CategoryRepository categoryRepository;

    @Autowired
    @Qualifier("categoryTranslator")
    private Translator<CategoryDTO, Category> categoryTranslator;

    @Autowired
    @Qualifier("categoryDTOTranslator")
    private Translator<Category, CategoryDTO> categoryDTOTranslator;

    public void save(final CategoryDTO category){
        categoryRepository.save(categoryTranslator.translate(category));
    }

    public List<CategoryDTO> findAll(){
        return categoryRepository.findAllSortName();
    }

    public void delete(final Long idCategory){
        categoryRepository.deleteById(idCategory);
    }


    public boolean existName(final String name) {
        List<Category> categories = categoryRepository.findByName(name);
        return categories != null && !categories.isEmpty();
    }


    public boolean existNameForOtherRecords(final String name, final Long id){
        List<Category> categories = categoryRepository.findByNameForOtherRecords(name, id);
        return categories != null && !categories.isEmpty();
    }


}
