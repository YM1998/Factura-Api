package co.com.system.invoice.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.com.system.invoice.domain.CategoryDTO;
import co.com.system.invoice.exception.AppException;
import co.com.system.invoice.service.interfaces.ICategoryService;

/**@author Yesid
 */
@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired private ICategoryService categoryService;

    @GetMapping(value = "/getAll")
    public List<CategoryDTO> getAll(){
         return categoryService.findAll();
    }

    @PostMapping(value = "/save")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void  save(@RequestBody CategoryDTO category) throws AppException {
       categoryService.save(category);
    }

    @DeleteMapping(value = "/delete/{idCategory}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("idCategory") Long idCategory) throws AppException {
        categoryService.delete(idCategory);
    }

}
