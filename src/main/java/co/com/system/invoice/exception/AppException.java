package co.com.system.invoice.exception;

import co.com.system.invoice.constants.CodeExceptions;
import co.com.system.invoice.utils.PropertiesUtil;

public class AppException extends Exception{

    private static final long serialVersionUID = 1L;

    private String codError = null;
    private static final String FILE_EXCEPTIONS="exception.properties";

    public AppException(final CodeExceptions codError) {
        super(new PropertiesUtil().getPropValues(FILE_EXCEPTIONS, codError.getValue()));
        this.codError = codError.getValue();
    }

    public String getCodError() {
        return codError;
    }

}
