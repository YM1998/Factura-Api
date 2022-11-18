package co.com.system.invoice.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductUpdate {
    private Product productDTO;
    private List<Long> attributesToDelete;


    public boolean attributesToDeleteIsNotEmpty() {
        return this.attributesToDelete != null && !this.attributesToDelete.isEmpty();
    }

    public boolean attributesNotEmpty() {
        return this.productDTO.getAttributes() != null && !this.productDTO.getAttributes().isEmpty();
    }


}
