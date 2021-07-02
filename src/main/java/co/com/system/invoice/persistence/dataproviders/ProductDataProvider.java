package co.com.system.invoice.persistence.dataproviders;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import co.com.system.invoice.constants.CodeExceptions;
import co.com.system.invoice.domain.AttributeDTO;
import co.com.system.invoice.domain.ProductDTO;
import co.com.system.invoice.domain.ProductUpdateDTO;
import co.com.system.invoice.exception.AppException;
import co.com.system.invoice.persistence.entity.Attribute;
import co.com.system.invoice.persistence.entity.Product;
import co.com.system.invoice.persistence.entity.ProductAtribute;
import co.com.system.invoice.persistence.repository.ProductRepository;
import co.com.system.invoice.translators.Translator;
import co.com.system.invoice.translators.TranslatorReference;

@Repository
public class ProductDataProvider {


    @Autowired private ProductRepository productRepository;

    @Autowired
    @Qualifier("productTranslator")
    private Translator<ProductDTO, Product> productTranslator;

    @Autowired
    @Qualifier("productDTOTranslator")
    private Translator<Product, ProductDTO> productDTOTranslator;

    @Autowired
    @Qualifier("productTranslatorReference")
    private TranslatorReference<ProductDTO, Product> productTranslatorReference;

    public void save(ProductDTO product) {
        Product productToPersist = productTranslator.translate(product);
        productToPersist.setFechaModificacion(new Date());
        productToPersist.setFechaCreacion(new Date());
        productRepository.save(productToPersist);
   }

   public void update(ProductUpdateDTO productUpdate) throws AppException {
       Product currentProduct = validateUpdate(productUpdate);
       productTranslatorReference.translateReference(productUpdate.getProductDTO(), currentProduct);
       updateAndAddAttributes(productUpdate, currentProduct);
       productRepository.save(currentProduct);

        if(productUpdate.attributesToDeleteIsNotEmpty())
           productRepository.deleteAttributes(productUpdate.getAttributesToDelete());

   }

   private void updateAndAddAttributes(ProductUpdateDTO productUpdate, Product product) {
       if(productUpdate.attributesNotEmpty()) {
           updateValueAttributes(productUpdate, product);
           addNewAttributes(productUpdate, product);
       }
   }

   /**
    * Update value attributes.
    * Se filtran lso atributos que existen actualmente en BD y
    * se les atualiza el valor con lo enviado
    * @param productUpdate the product update
    * @param product the product
    */
   private void updateValueAttributes(ProductUpdateDTO productUpdate, Product product) {
       if(product.attributesIsEmpty())
           return;

       for(AttributeDTO att: productUpdate.getProductDTO().getAttributes()) {
           product.getProductosAtributos()
                         .stream()
                         .filter(ptt -> ptt.getIdProductoAtributo().equals(att.getIdProductAttribute()))
                         .findAny()
                         .ifPresent(ptt -> ptt.setValor(att.getValue()));
       }
   }

   /**
    * Adds the new attributes.
    * se filtran los atributos que no estan en la lista y se
    * adicionan  a la lista del objeto a persistir(product)
    * @param productUpdate the product update
    * @param product the product
    */
   private void addNewAttributes(ProductUpdateDTO productUpdate, Product product) {
       productUpdate.getProductDTO()
       .getAttributes()
       .stream()
       .filter(attr -> product.getProductosAtributos()
                                     .stream()
                                     .noneMatch(ptt -> attr.getIdProductAttribute().equals(ptt.getIdProductoAtributo())))
       .forEach(attr -> product.getProductosAtributos().add(ProductAtribute.builder()
                                                                   .atributo(new Attribute(attr.getIdAttribute()))
                                                                   .idProductoAtributo(attr.getIdProductAttribute())
                                                                   .valor(attr.getValue())
                                                                   .producto(product)
                                                                   .build()));

   }

   /**
    * Validate update.
    * Metodo que obtiene el producto mediante el ID, ademas valida
    * la existencia de este
    * @param productUpdateDTO the product update DTO
    * @return the product
    * @throws AppException the app exception
    */
   private Product validateUpdate(ProductUpdateDTO productUpdateDTO) throws AppException {
       Product product = findByIdRepository(productUpdateDTO.getProductDTO().getIdProduct());

       if(product == null) {
           throw new AppException(CodeExceptions.PRODUCT_NOT_EXIST);
       }

       return product;
   }



    public Long countByIdCategoria(Long idCategoria){
        return productRepository.countByIdCategoria(idCategoria);
    }


    public ProductDTO findById(Long idProduct) {
        Product product = findByIdRepository(idProduct);
        return product!=null? productDTOTranslator.translate(product):null;
     }

    private Product findByIdRepository(Long idProduct) {
        Optional<Product> product = productRepository.findById(idProduct);
        return product.isPresent()? product.get():null;
     }

    /**
     * Find all.
     * Se consultan los productos y atributos en BD y se
     * organizan, los productos con su respectiva lista de productos
     * @return the list
     */
    public List<ProductDTO> findAll() {
        List<ProductDTO> products = productRepository.findAllProducts();
        return products.stream()
                       .distinct()
                       .map( p -> {
                                   p.setAttributes(getAttributes(products, p));
                                   return p;
                                  })
                       .collect(Collectors.toList());
    }


    /**
     * Crea una lista de atributos a partir de una lista de productos
     * de acuerdo a producto enviado lo filtra en la lista y va adicionando sus
     * atributos(si los tienen) a una coleccion
     * @param productsAll the products all
     * @param idProduct the id product
     * @return the attributes
     */
    private List<AttributeDTO> getAttributes(final List<ProductDTO> productsAll, ProductDTO product) {
        return  productsAll.stream()
                .filter(p -> p.equals(product) && p.getAttribute()!=null )
                .map(ProductDTO::getAttribute)
                .collect(Collectors.toList());
    }


    public List<ProductDTO> findByNameOrCode(String filter) {
        return productRepository.findByNameOrCode(filter);
    }
}
