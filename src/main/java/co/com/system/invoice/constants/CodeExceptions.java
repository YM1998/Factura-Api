package co.com.system.invoice.constants;

public enum CodeExceptions {

    NAME_EXIST("G001"),
    CATEGORY_CANNOT_BE_DELETED("C001"),
    PRODUCT_NOT_EXIST("P001");


    private String value;

    private CodeExceptions(final String value) {
        this.value=value;
    }

    public String getValue() {
        return value;
    }

}
