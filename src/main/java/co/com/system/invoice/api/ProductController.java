package co.com.system.invoice.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.system.invoice.domain.ProductDTO;
import co.com.system.invoice.domain.ProductFilter;
import co.com.system.invoice.service.ProductService;

/**@author Yesid
 */
@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping(value = "/getAll")
    public List<ProductDTO> getAll(){
         return productService.findAll();
    }

    @PostMapping(value = "/findByCriteria")
    public List<ProductDTO> findByCriteria(@RequestBody final ProductFilter productFilter){
         return productService.findByCriteria(productFilter);
    }

}
