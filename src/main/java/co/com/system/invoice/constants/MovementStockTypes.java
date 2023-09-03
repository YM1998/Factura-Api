package co.com.system.invoice.constants;

import lombok.Getter;

@Getter
public enum MovementStockTypes {


    STOCK_IN(1),STOCK_OUT(2),STOCK_UPDATE(3), STOCK_OUT_BY_SALES(4);

    private Integer value;

    private MovementStockTypes(Integer value) {
        this.value = value;
    }

}
