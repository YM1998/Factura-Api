package co.com.system.invoice.persistence.product;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import co.com.system.invoice.persistence.state.StateEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.system.invoice.constants.CodeExceptions;
import co.com.system.invoice.model.Product;
import co.com.system.invoice.model.ProductUpdate;
import co.com.system.invoice.exception.AppException;

@Repository
public class ProductDataProvider {


    @Autowired private ProductRepository productRepository;
    @Autowired private ProductMapper productMapper;
    @Autowired private ProductDataProviderUtil productDataProviderUtil;

    public void save(Product product) {
        ProductEntity productToPersist = productMapper.toEntity(product);
        productToPersist.setCreatedAt(LocalDate.now());
        productRepository.save(productToPersist);
   }

    public void updateStatus(Long idProduct, Long statusId ) throws AppException {
        ProductEntity productEntity = validateUpdate(idProduct);
        productEntity.setState(StateEntity.builder().id(statusId).build());
        productRepository.save(productEntity);
    }


    public void update(ProductUpdate productUpdate) throws AppException {
       ProductEntity currentProduct = validateUpdate(productUpdate.getProductDTO().getIdProduct());
       productMapper.translateReference(productUpdate.getProductDTO(), currentProduct);
       updateAndAddAttributes(productUpdate, currentProduct);
       productRepository.save(currentProduct);

       if(productUpdate.attributesToDeleteIsNotEmpty())
          productRepository.deleteAttributes(productUpdate.getAttributesToDelete());

   }

   private void updateAndAddAttributes(ProductUpdate productUpdate, ProductEntity product) {
       if(productUpdate.attributesNotEmpty()) {
           productDataProviderUtil.updateValueAttributes(productUpdate, product);
           productDataProviderUtil.addNewAttributes(productUpdate, product);
       }
   }


   private ProductEntity validateUpdate(Long idProduct) throws AppException {
       Optional<ProductEntity> product = productRepository.findById(idProduct);
       if(!product.isPresent())  throw new AppException(CodeExceptions.PRODUCT_NOT_EXIST);
       return product.get();
   }



    public Long countByIdCategory(Long idCategory){
        return productRepository.countByIdCategory(idCategory);
    }


    public Optional<Product> findById(Long idProduct) {
        Optional<ProductEntity> product=  productRepository.findById(idProduct);
        return product.isPresent()? Optional.of(productMapper.toData(product.get())): Optional.empty();
     }

     public void updateQuantityInventory(Long idProduct, Integer amount ) {
        productRepository.updateQuantityInventory(idProduct, amount);
     }

     public List<Product> findAll() {
        return  productRepository.findAllProducts();
    }

    public List<Product> findBySellingPoint(Integer sellingPointId) {
        return  productRepository.findBySellingPoint(sellingPointId)
                                 .stream()
                                 .map(productMapper::toData)
                                 .collect(Collectors.toList());
    }


    public List<Product> findByNameOrCode(String filter) {
        return productRepository.findLikeByNameOrCode(filter);
    }

    public boolean existCode(final String code) {
        return productRepository.findByCode(code)!=null;
    }

    public boolean existCodeForOtherRecords(final String code, final Long id){
        List<ProductEntity> products = productRepository.findByCodeForOtherRecords(code, id);
        return products != null && !products.isEmpty();
    }

    public Optional<Product> findByCode(final String code) {
        ProductEntity product = productRepository.findByCode(code);
        return product!=null ?Optional.of(productMapper.toData(product)):Optional.empty();
    }

}
