package co.com.system.invoice.persistence.product.stock;

import co.com.system.invoice.model.Product;
import co.com.system.invoice.model.ProductStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProductStockDataProvider {

    @Autowired ProductStockEntityRepository productStockEntityRepository;
    @Autowired ProductEntityMapper productEntityMapper;



    public void save(ProductStock productStock) {
        productStockEntityRepository.save(productEntityMapper.toEntity(productStock));
    }

    public List<ProductStock> findBySellingPoint(Integer sellingPointId) {
        return productStockEntityRepository.findBySellingPointId(sellingPointId)
                .stream()
                .map(productEntityMapper::toData)
                .collect(Collectors.toList());
    }

    public void updateQuantityInventory(Long idProduct, Integer amount, Integer sellingPointId ) {
        productStockEntityRepository.updateQuantityInventory(idProduct, amount, sellingPointId);
    }

    public void updateQuantityInventoryByOperation(Long idProduct, Integer amount,  Integer sellingPointId ) {
        productStockEntityRepository.updateQuantityInventoryByOperation(idProduct, amount, sellingPointId);
    }

    public Optional<ProductStock> findByProduct(Long productId, Integer sellingPointId) {
        ProductStockEntity productStockEntity = productStockEntityRepository.findByProduct(productId, sellingPointId);
        return productStockEntity!=null ? Optional.of(productEntityMapper.toData(productStockEntity)): Optional.empty();
    }


}
