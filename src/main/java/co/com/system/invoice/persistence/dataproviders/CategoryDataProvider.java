package co.com.system.invoice.persistence.dataproviders;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import co.com.system.invoice.domain.CategoryDTO;
import co.com.system.invoice.persistence.dataproviders.interfaces.ICategoryDataProvider;
import co.com.system.invoice.persistence.entity.Category;
import co.com.system.invoice.persistence.repository.CategoryRepository;
import co.com.system.invoice.translators.Translator;

@Component
public class CategoryDataProvider implements ICategoryDataProvider{

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    @Qualifier("categoryTranslator")
    private Translator<CategoryDTO, Category> categoryTranslator;

    @Autowired
    @Qualifier("categoryDTOTranslator")
    private Translator<Category, CategoryDTO> categoryDTOTranslator;

    @Override
    public CategoryDTO save(final CategoryDTO category) throws Exception {
        Category categorySave = categoryRepository.save(categoryTranslator.translate(category));
        return categoryDTOTranslator.translate(categorySave);
    }

    @Override
    public CategoryDTO findById(final Long id) throws Exception {
       Optional<Category> category =  categoryRepository.findById(id);
       return category.isPresent() ? categoryDTOTranslator.translate(category.get()) : null;
    }

    @Override
    public List<CategoryDTO> findAll() throws Exception {
        List<Category> categorys = categoryRepository.findAll();
        return categorys.stream()
                        .map(categoryDTOTranslator::translate)
                        .collect(Collectors.toList());
    }

    @Override
    public boolean  existName(final String name) throws Exception {
        List<Category> categories = categoryRepository.findByName(name);
        return categories!=null && !categories.isEmpty();
    }

    @Override
    public boolean existNameForOtherRecords(final String name, final Long id)
            throws Exception {
        return categoryRepository.existNameForOtherRecords(name, id);
    }

}
