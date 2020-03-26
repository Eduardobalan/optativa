package br.com.albus.generic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Eduardo Balan on 13/09/2018.
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class GenericSqlRuntimeException extends GenericRuntimeException {

    private static final long serialVersionUID = -992023069943994640L;

    public GenericSqlRuntimeException(Exception e) {
        super(e.getMessage(), e.getCause());
    }

    public GenericSqlRuntimeException(String s, Exception e) {
        super(s, e.getCause());
    }

    @Override
    public String getMessage() {
        return "exception DB -> " + super.getMessage();
    }

}
