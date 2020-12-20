package co.com.system.invoice.handlers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import co.com.system.invoice.domain.ErrorResponseDTO;
import co.com.system.invoice.exception.AppException;
import lombok.extern.log4j.Log4j2;

/**
 * Reflects exceptions generic logic related
 *
 * @author carvajal
 * @version 1.0
 * @since 2018-12-07
 */

@Log4j2
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AppException.class)
    public ResponseEntity<ErrorResponseDTO> handlingApplicationException(
            final HttpServletRequest request,
            final AppException exception) {
        return new ResponseEntity<>(ErrorResponseDTO
                                    .builder()
                                    .codError(exception.getCodError())
                                    .messageError(exception.getMessage()).build(), HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handlingGenericException(
            final HttpServletRequest request, final Exception exception) {
        log.error("error processing generic exception on request", exception);
        return new ResponseEntity<>(ErrorResponseDTO
                .builder()
                .codError("GENERAL-ERROR")
                .messageError(exception.getMessage()).build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponseDTO> handlingGenericException(
            final HttpServletRequest request, final RuntimeException exception) {
        log.error("error processing generic exception on request", exception);
        return new ResponseEntity<>(ErrorResponseDTO
                .builder()
                .codError("GENERAL-ERROR")
                .messageError(exception.getMessage()).build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
