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

public class CreateCategoryServiceTest {

    @InjectMocks private CreateCategoryService createCategoryService;
    @Mock  private CategoryDataProvider categoryDataProvider;
    private Category category;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        category = Category.builder().name("Jeans").build();
    }

    @Test
    public void saveErrorExistName() {
        mockMethodExistNameCreate(Boolean.TRUE);
        AppException thrown = Assertions.assertThrows(AppException.class, () -> createCategoryService.save(category));
        Assertions.assertEquals(CodeExceptions.NAME_EXIST.getValue(), thrown.getCodError());
    }

    @Test
    public void saveSuccessful() throws AppException{
        mockMethodExistNameCreate(Boolean.FALSE);
        createCategoryService.save(category);
        Mockito.verify(categoryDataProvider).save(Mockito.any());
    }

    private void mockMethodExistNameCreate(Boolean expectedValue){
        Mockito.when(categoryDataProvider.existName(Mockito.anyString()))
                .thenReturn(expectedValue);
    }
}
