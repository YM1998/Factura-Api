package co.com.system.invoice.persistence.dataproviders;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import co.com.system.invoice.domain.CategoryDTO;
import co.com.system.invoice.persistence.entity.Category;
import co.com.system.invoice.persistence.repository.CategoryRepository;
import co.com.system.invoice.translators.Translator;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CategoryDataProviderTest {

    @InjectMocks
    private CategoryDataProvider categoryDataProvider;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private Translator<CategoryDTO, Category> categoryTranslator;

    @Mock
    private Translator<Category, CategoryDTO> categoryDTOTranslator;

    private static final String CATEGORY_NAME = "category1";
    private static final Long   ID_CATEGORY = 1L;


    @Test
    public void save() throws Exception {
        whenCategoryDTOTranslator();
        whenCategoryTranslator();
        when(categoryRepository.save(any(Category.class)))
        .thenReturn(new Category());
        assertNotNull(categoryDataProvider.save(new CategoryDTO()));
    }

    @Test
    public void findAll() throws Exception {
      whenCategoryDTOTranslator();
      when(categoryRepository.findAllSortName()).thenReturn(Arrays.asList(new Category()));
      assertNotNull(categoryDataProvider.findAll());
    }
    @Test
    public void existName() throws Exception {
      when(categoryRepository.findByName(CATEGORY_NAME)).thenReturn(Arrays.asList(new Category()));
      assertTrue(categoryDataProvider.existName(CATEGORY_NAME));
    }

    @Test
    public void notExistName() throws Exception {
       assertFalse(categoryDataProvider.existName(CATEGORY_NAME));
    }

   @Test
   public void existNameForOtherRecords() throws Exception {
       when(categoryRepository.findByNameForOtherRecords(CATEGORY_NAME, ID_CATEGORY))
       .thenReturn(Arrays.asList(new Category()));
       assertTrue(categoryDataProvider.existNameForOtherRecords(CATEGORY_NAME, ID_CATEGORY));
   }

   @Test
   public void notExistNameForOtherRecords() throws Exception {
     assertFalse(categoryDataProvider.existNameForOtherRecords(CATEGORY_NAME, ID_CATEGORY));
   }

   @Test
   public void delete() throws Exception {
      categoryDataProvider.delete(ID_CATEGORY);
      verify(categoryRepository).deleteById(ID_CATEGORY);
   }

   private void whenCategoryDTOTranslator() {
        when(categoryDTOTranslator.translate(any(Category.class)))
        .thenReturn(new CategoryDTO());
   }

   private void whenCategoryTranslator() {
        when(categoryTranslator.translate(any(CategoryDTO.class)))
        .thenReturn(new Category());
   }

}
