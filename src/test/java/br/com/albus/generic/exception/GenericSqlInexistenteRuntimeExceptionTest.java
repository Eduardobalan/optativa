package br.com.albus.generic.exception;

import org.junit.Test;

public class GenericSqlInexistenteRuntimeExceptionTest {

    @Test(expected = GenericSqlInexistenteRuntimeException.class)
    public void genericEntityTestExceptionTest() throws GenericSqlInexistenteRuntimeException {
        throw new GenericSqlInexistenteRuntimeException("msg", null);
    }

    @Test(expected = GenericSqlInexistenteRuntimeException.class)
    public void genericEntityTestException2Test() throws GenericSqlInexistenteRuntimeException {
        throw new GenericSqlInexistenteRuntimeException(new Exception());
    }

}