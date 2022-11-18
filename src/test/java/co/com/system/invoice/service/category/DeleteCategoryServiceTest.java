package co.com.system.invoice.service.category;

import co.com.system.invoice.constants.CodeExceptions;
import co.com.system.invoice.exception.AppException;
import co.com.system.invoice.model.Category;
import co.com.system.invoice.persistence.category.CategoryDataProvider;
import co.com.system.invoice.service.product.GetProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class DeleteCategoryServiceTest {

    @InjectMocks
    private DeleteCategoryService deleteCategoryService;
    @Mock
    private CategoryDataProvider categoryDataProvider;
    @Mock private GetProductService getProductService;
    private Category category;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        category = Category.builder().name("Jeans").build();
    }

    @Test
    public void DeleteErrorCategoryHasProducts() {
        Mockito.when(getProductService.countByIdCategory(Mockito.anyLong())).thenReturn(1L);
        AppException thrown = Assertions.assertThrows(AppException.class, () -> deleteCategoryService.delete(1L));
        Assertions.assertEquals(CodeExceptions.CATEGORY_CANNOT_BE_DELETED.getValue(), thrown.getCodError());
    }

    @Test
    public void DeleteSuccessful() throws  AppException{
        deleteCategoryService.delete(1L);
        Mockito.verify(categoryDataProvider).delete(Mockito.anyLong());
    }


}
