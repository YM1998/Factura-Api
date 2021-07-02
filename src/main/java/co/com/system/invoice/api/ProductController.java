package co.com.system.invoice.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.com.system.invoice.domain.ProductDTO;
import co.com.system.invoice.domain.ProductUpdateDTO;
import co.com.system.invoice.exception.AppException;
import co.com.system.invoice.service.ProductService;

/**@author Yesid
 */
@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired private ProductService productService;


    @PostMapping(value = "/save")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void save(@Valid @RequestBody final ProductDTO product) {
        productService.save(product);
    }

    @PutMapping(value = "/update")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody final ProductUpdateDTO productUpdate) throws AppException {
        productService.update(productUpdate);
    }

    @GetMapping(value = "/getAll")
    public List<ProductDTO> getAll(){
         return productService.findAll();
    }

    @GetMapping(value = "/find/{id}")
    public ProductDTO findById(@PathVariable("id") Long idProduct){
         return productService.findById(idProduct);
    }

    @GetMapping(value = "/findByNameOrCode/{filter}")
    public List<ProductDTO> findByNameOrCode(@PathVariable("filter") String filter){
         return productService.findByNameOrCode(filter);
    }


}
