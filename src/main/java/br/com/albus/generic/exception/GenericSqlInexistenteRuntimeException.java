package br.com.albus.generic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Eduardo Balan on 13/09/2018.
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class GenericSqlInexistenteRuntimeException extends RuntimeException {
    private static final long serialVersionUID = -152033113069196630L;

    public GenericSqlInexistenteRuntimeException(Exception e) {
        super(e.getMessage(), e.getCause());
    }

    public GenericSqlInexistenteRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public GenericSqlInexistenteRuntimeException(String message) {
        super(message, null);
    }
}
