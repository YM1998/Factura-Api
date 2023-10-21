package co.com.system.invoice.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductStock {

    private Long id;
    private Long productId;
    private Integer sellingPointId;
    private Integer stock;
}
