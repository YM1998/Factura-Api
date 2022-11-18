package co.com.system.invoice.model;

import java.util.Map;


import co.com.system.invoice.constants.GeneralConstans;
import co.com.system.invoice.utils.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductFilter {

    private Long idCategory;
    private Long idStatus;
    private String statusInventory;
    private Map<Long, String> filterAtributtes;


    public boolean isCategory() {
       return this.idCategory!=null;
    }

    public boolean isStatus() {
        return this.idStatus!=null;
    }

    public boolean isStatusInventory() {
        return StringUtils.isNotEmpty(this.statusInventory);
    }

    public boolean islowInventory() {
        return isStatusInventory() &&
               statusInventory.equals(GeneralConstans.LOW_INVENTORY);
    }

    public boolean isStableInventory() {
        return isStatusInventory() &&
                statusInventory.equals(GeneralConstans.STABLE_INVENTORY);
    }

    public boolean isExceededInventory() {
        return isStatusInventory() &&
                statusInventory.equals(GeneralConstans.EXCEEDED_INVENTORY);
    }




}
