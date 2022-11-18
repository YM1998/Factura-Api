package co.com.system.invoice.service.category;

import co.com.system.invoice.constants.CodeExceptions;
import co.com.system.invoice.exception.AppException;
import co.com.system.invoice.model.Category;
import co.com.system.invoice.persistence.category.CategoryDataProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class UpdateCategoryServiceTest {

    @InjectMocks  private UpdateCategoryService updateCategoryService;
    @Mock private CategoryDataProvider categoryDataProvider;
    private Category category;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        category = Category.builder().name("Jeans").build();
    }



    @Test
    public void updateErrorExistName() {
        category.setIdCategory(1L);
        mockMethodFindById(category);
        mockMethodExistNameUpdate(Boolean.TRUE);
        AppException thrown = Assertions.assertThrows(AppException.class, () -> updateCategoryService.update(category));
        Assertions.assertEquals(CodeExceptions.NAME_EXIST.getValue(), thrown.getCodError());
    }

    @Test
    public void updateErrorNotExistCategory() {
        category.setIdCategory(1L);
        AppException thrown = Assertions.assertThrows(AppException.class, () -> updateCategoryService.update(category));
        Assertions.assertEquals(CodeExceptions.CATEGORY_NOT_EXIST.getValue(), thrown.getCodError());
    }

    @Test
    public void updateSuccessful() throws AppException{
        mockMethodFindById(category);
        mockMethodExistNameUpdate(Boolean.FALSE);
        category.setIdCategory(1L);
        updateCategoryService.update(category);
        Mockito.verify(categoryDataProvider).save(Mockito.any());
    }

    private void mockMethodExistNameUpdate(Boolean expectedValue){
        Mockito.when(categoryDataProvider.existNameForOtherRecords(Mockito.anyString(), Mockito.anyLong()))
                .thenReturn(expectedValue);
    }

    private void mockMethodFindById(Category categoryExpected){
        Mockito.when(categoryDataProvider.findById(Mockito.anyLong()))
                .thenReturn(categoryExpected)   ;
    }
}
