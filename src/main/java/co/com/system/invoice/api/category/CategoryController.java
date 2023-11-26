package co.com.system.invoice.api.category;

import java.util.List;

import co.com.system.invoice.service.category.CreateCategoryService;
import co.com.system.invoice.service.category.DeleteCategoryService;
import co.com.system.invoice.service.category.GetCategoryService;
import co.com.system.invoice.service.category.UpdateCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.system.invoice.model.Category;
import co.com.system.invoice.exception.AppException;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/category")
public class CategoryController implements  ICategoryController{

    private final  CreateCategoryService createCategoryService;
    private final  UpdateCategoryService updateCategoryService;
    private final DeleteCategoryService deleteCategoryService;
    private final GetCategoryService getCategoryService;




    @Override
    public List<Category> getAll(){
         return getCategoryService.findAll();
    }

    @Override
    public void  save(@Valid  @RequestBody Category category) throws AppException {
        createCategoryService.save(category);
    }

    @Override
    public void update(@Valid  @RequestBody Category category) throws AppException {
        updateCategoryService.update(category);
    }

    @Override
    public void delete(@PathVariable("idCategory") Long idCategory) throws AppException {
        deleteCategoryService.delete(idCategory);
    }

}
