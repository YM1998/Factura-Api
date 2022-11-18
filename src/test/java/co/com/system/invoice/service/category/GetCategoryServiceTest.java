package co.com.system.invoice.service.category;

import co.com.system.invoice.persistence.category.CategoryDataProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

public class GetCategoryServiceTest {

    @InjectMocks private GetCategoryService getCategoryService;
    @Mock private CategoryDataProvider categoryDataProvider;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void finAll() {
        Mockito.when(categoryDataProvider.findAll()).thenReturn(Collections.emptyList());
        Assertions.assertNotNull(getCategoryService.findAll());
    }

}
