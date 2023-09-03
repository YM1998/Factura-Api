package co.com.system.invoice.persistence.movement.stock.type;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="type_movement_stock")
public class MovementStockTypeEntity {

    @Id
    @Column
    private Integer id;

    @Column private String name;
}
