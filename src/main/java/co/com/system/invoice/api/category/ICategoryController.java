package co.com.system.invoice.api.category;

import co.com.system.invoice.exception.AppException;
import co.com.system.invoice.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**@author Yesid
 */
@RestController
@RequestMapping(value = "/category")
public interface ICategoryController {

    @GetMapping(value = "/getAll")
    public List<Category> getAll();

    @PostMapping(value = "/save")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void  save(@Valid  @RequestBody Category category) throws AppException;


    @PutMapping(value = "/update")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void  update(@Valid  @RequestBody Category category) throws AppException;


    @DeleteMapping(value = "/delete/{idCategory}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("idCategory") Long idCategory) throws AppException;
}
