package br.com.albus.generic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Eduardo Balan on 13/09/2018.
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class GenericRuntimeException extends RuntimeException {

    private static final long serialVersionUID = -992023069943994639L;

    public GenericRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

}