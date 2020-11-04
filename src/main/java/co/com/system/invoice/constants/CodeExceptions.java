package co.com.system.invoice.constants;

public enum CodeExceptions {

    NAME_EXIST("S001");

    private String value;

    private CodeExceptions(final String value) {
        this.value=value;
    }

    public String getValue() {
        return value;
    }

}
