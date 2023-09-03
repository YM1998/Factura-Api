package co.com.system.invoice.model;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class MovementStock {

    private Long id;
    private Integer lastValue;
    private Integer currentValue;
    @NotNull(message = "Ingrese el movimiento")
    private Integer movementValue;
    private String reason;
    @NotNull(message = "Ingrese el tipo de movimiento")
    private Integer typeMovementStockId;
    @NotNull(message = "Ingrese el producto")
    private Long productId;
    private LocalDate createdAt;

}
