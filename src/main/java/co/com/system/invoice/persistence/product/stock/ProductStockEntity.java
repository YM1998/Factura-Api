package co.com.system.invoice.persistence.product.stock;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name="selling_points_product_stock")
public class ProductStockEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column private Long productId;
    @Column private Integer sellingPointId;
    @Column private Integer stock;
}
