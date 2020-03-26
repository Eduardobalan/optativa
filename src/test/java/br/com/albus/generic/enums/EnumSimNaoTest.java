package br.com.albus.generic.enums;

import org.junit.Assert;
import org.junit.Test;

public class EnumSimNaoTest {

    @Test
    public void enumSimNaoTest() {
        EnumSimNao n = EnumSimNao.valueOf("N");
        Assert.assertEquals(n.getValue(), EnumSimNao.N.getValue());

        EnumSimNao s = EnumSimNao.valueOf("S");
        Assert.assertEquals(s.getValue(), EnumSimNao.S.getValue());
    }
}
