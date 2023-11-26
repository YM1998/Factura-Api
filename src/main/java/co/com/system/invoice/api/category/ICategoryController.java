package co.com.system.invoice.api.category;

import co.com.system.invoice.constants.RolesEnum;
import co.com.system.invoice.exception.AppException;
import co.com.system.invoice.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**@author Yesid
 */
@RestController
@RequestMapping(value = "/category")
public interface ICategoryController {

    @Secured(RolesEnum.ROLE_ADMIN)
    @GetMapping(value = "/getAll")
    public List<Category> getAll();

    @Secured(RolesEnum.ROLE_ADMIN)
    @PostMapping(value = "/save")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void  save(@Valid  @RequestBody Category category) throws AppException;

    @Secured(RolesEnum.ROLE_ADMIN)
    @PutMapping(value = "/update")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void  update(@Valid  @RequestBody Category category) throws AppException;

    @Secured(RolesEnum.ROLE_ADMIN)
    @DeleteMapping(value = "/delete/{idCategory}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("idCategory") Long idCategory) throws AppException;
}
