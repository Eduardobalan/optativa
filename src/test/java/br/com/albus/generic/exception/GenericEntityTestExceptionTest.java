package br.com.albus.generic.exception;

import org.junit.Test;

public class GenericEntityTestExceptionTest {

    @Test(expected = GenericEntityTestException.class)
    public void GenericEntityTestExceptionTest() throws GenericEntityTestException {
        throw new GenericEntityTestException();
    }

    @Test(expected = GenericEntityTestException.class)
    public void GenericEntityTestException2Test() throws GenericEntityTestException {
        throw new GenericEntityTestException("Teste", null);
    }
}