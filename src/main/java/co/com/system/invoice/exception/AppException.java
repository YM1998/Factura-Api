package co.com.system.invoice.exception;

import co.com.system.invoice.constants.CodeExceptions;
import co.com.system.invoice.utils.PropertiesUtil;
import lombok.Getter;

@Getter
public class AppException extends Exception{

    private static final long serialVersionUID = 1L;

    private String codError;


    public AppException(final CodeExceptions codError) {
        super(new PropertiesUtil().getValueException(codError.getValue()));
        this.codError = codError.getValue();
    }

    /*public String getCodError() {
        return codError;
    }*/

}
