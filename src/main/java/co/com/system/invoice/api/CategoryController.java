package co.com.system.invoice.api;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.system.invoice.constants.DateFormats;
import co.com.system.invoice.domain.CategoryDTO;
import co.com.system.invoice.service.interfaces.ICategoryService;

/**@author Yesid
 */
@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;


    @GetMapping(value = "/getAll")
    public List<CategoryDTO> getAll() throws Exception{
         return categoryService.findAll();
    }

    @GetMapping(value = "/{id}")
    public CategoryDTO findById(@PathVariable("id") Long id) throws Exception{
         return categoryService.findById(id);
    }

    @PostMapping(value = "/save")
    public CategoryDTO save(@RequestBody CategoryDTO category) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DateFormats.DD_MM_YYYY.getValue());
        category.setCreationDate(dateFormat.format(new Date()));
        category.setModificationDate(dateFormat.format(new Date()));
        category.setCreationUser("system");
        category.setModificationUser("system");
        return categoryService.save(category);
    }

}
