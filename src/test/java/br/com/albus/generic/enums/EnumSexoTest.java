package br.com.albus.generic.enums;

import org.junit.Assert;
import org.junit.Test;

public class EnumSexoTest {

    @Test
    public void enumSexoTest() {
        EnumSexo masculino = EnumSexo.valueOf("MASCULINO");
        Assert.assertEquals(masculino.getValue(), EnumSexo.MASCULINO.getValue());

        EnumSexo feminino = EnumSexo.valueOf("FEMININO");
        Assert.assertEquals(feminino.getValue(), EnumSexo.FEMININO.getValue());
    }
}
