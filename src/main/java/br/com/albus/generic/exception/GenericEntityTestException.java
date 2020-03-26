package br.com.albus.generic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class GenericEntityTestException extends Exception {
    public GenericEntityTestException() {
        super("Teste Error.");
    }
    public GenericEntityTestException(String message, Throwable cause) {
        super(message, cause);
    }
}