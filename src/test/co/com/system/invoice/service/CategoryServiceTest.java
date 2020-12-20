package co.com.system.invoice.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import co.com.system.invoice.constants.CodeExceptions;
import co.com.system.invoice.domain.CategoryDTO;
import co.com.system.invoice.exception.AppException;
import co.com.system.invoice.persistence.dataproviders.interfaces.ICategoryDataProvider;
import co.com.system.invoice.service.interfaces.IProductService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CategoryServiceTest {

    @InjectMocks
    private CategoryService categoryService;

    @Mock
    private ICategoryDataProvider categoryDataProvider;

    @Mock
    private IProductService productService;


    private CategoryDTO categoryDTO;


    @Before
    public void setup() {
        categoryDTO = CategoryDTO.builder()
                                 .name("Category1")
                                 .build();
    }

    @Test
    public void save() throws Exception {
        whenMethodExistName(false);
        categoryService.save(categoryDTO);
        verify(categoryDataProvider).save(categoryDTO);
    }


    @Test
    public void saveErrorExistName() throws Exception {
        try {
            whenMethodExistName(true);
            categoryService.save(categoryDTO);
        }catch (AppException e) {
            assertEquals(CodeExceptions.NAME_EXIST.getValue(), e.getCodError());
            return;
        }
        fail();
    }

    @Test
    public void saveUpdate() throws Exception {
        whenMethodExistNameForOtherRecords(false);
        categoryDTO.setIdCategory(1L);
        categoryService.save(categoryDTO);
        verify(categoryDataProvider).save(categoryDTO);
    }


    @Test
    public void saveUpdateErrorExistName() throws Exception {
        try {
            whenMethodExistNameForOtherRecords(true);
            categoryDTO.setIdCategory(1L);
            categoryService.save(categoryDTO);
        }catch (AppException e) {
            assertEquals(CodeExceptions.NAME_EXIST.getValue(), e.getCodError());
            return;
        }
        fail();
    }


    @Test
    public void findAll() throws Exception {
        when(categoryDataProvider.findAll()).thenReturn(new ArrayList<>());
        assertNotNull(categoryService.findAll());
    }

    @Test
    public void delete() throws Exception {
        Long id = 10L;
        categoryService.delete(id);
        verify(categoryDataProvider).delete(id);
    }

    @Test
    public void deleteErrorCannotBeDeleteted() throws Exception {
        Long id = 10L;
        try {
            when(productService.countByIdCategoria(id))
            .thenReturn(1L);
            categoryService.delete(id);
        }catch (AppException e) {
            assertEquals(CodeExceptions.CATEGORY_CANNOT_BE_DELETED.getValue(), e.getCodError());
            return;
        }

        fail();
    }

    private void whenMethodExistName(final boolean response) throws Exception {
        when(categoryDataProvider.existName(anyString())).thenReturn(response);
    }

    private void whenMethodExistNameForOtherRecords(final boolean response) throws Exception {
        when(categoryDataProvider.existNameForOtherRecords(anyString(), anyLong())).thenReturn(response);
    }

}
