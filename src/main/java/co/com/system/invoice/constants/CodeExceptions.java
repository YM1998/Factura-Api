package co.com.system.invoice.constants;

public enum CodeExceptions {

    NAME_EXIST("G001"),
    CATEGORY_CANNOT_BE_DELETED("C001"),
    CATEGORY_NOT_EXIST("C002"),
    PRODUCT_NOT_EXIST("P001"),
    PRODUCT_ATTRIBUTES_DUPLICATES("P002"),
    PRODUCT_CODES_DUPLICATES("P003"),
    PRODUCT_CODE_NOT_FOUND("P004"),
    SELLER_NOT_FOUND("PE001"),
    CLIENT_NOT_FOUND("PE002"),

    PAYMENT_TYPE_NOT_FOUND("INV001"),

    SELLING_POINT_NOT_FOUND("INV002");


    private String value;

    private CodeExceptions(final String value) {
        this.value=value;
    }

    public String getValue() {
        return value;
    }

}
