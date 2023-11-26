package co.com.system.invoice.service.product.stock;

import co.com.system.invoice.model.ProductStock;
import co.com.system.invoice.persistence.product.stock.ProductStockDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductStockService {

    private final ProductStockDataProvider productStockDataProvider;

    @Transactional
    public void save(ProductStock productStock) {
      productStockDataProvider.save(productStock);
    }

    public List<ProductStock> findBySellingPoint(Integer sellingPointId){
        return productStockDataProvider.findBySellingPoint(sellingPointId);
    }

    @Transactional
    public void updateQuantityInventory(Long idProduct, Integer amount, Integer sellingPointId ) {
        productStockDataProvider.updateQuantityInventory(idProduct, amount, sellingPointId);
    }

    @Transactional
    public void updateQuantityInventoryByOperation(Long idProduct, Integer amount,  Integer sellingPointId ) {
        productStockDataProvider.updateQuantityInventoryByOperation(idProduct, amount, sellingPointId);
    }

    public Optional<ProductStock> findByProduct(Long productId, Integer sellingPointId) {
        return productStockDataProvider.findByProduct(productId, sellingPointId);
    }
}
