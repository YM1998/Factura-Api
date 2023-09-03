package co.com.system.invoice.persistence.movement.stock;


import co.com.system.invoice.persistence.movement.stock.type.MovementStockTypeEntity;
import co.com.system.invoice.persistence.product.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="movement_stock")
public class MovementStockEntity {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column private Integer lastValue;
    @Column private Integer currentValue;
    @Column private Integer movementValue;
    @Column private String reason;
    @Column private LocalDate createdAt;

    @ManyToOne
    @JoinColumn(name = "type_movement_stock_id")
    private MovementStockTypeEntity movementStockTypeEntity;


    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;






}
