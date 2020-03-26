package br.com.albus.generic.enums;

import org.junit.Assert;
import org.junit.Test;

public class EnumSituacaoTest {

    @Test
    public void enumSituacaoTest() {
        EnumSituacao ativo = EnumSituacao.valueOf("ATIVO");
        Assert.assertEquals(ativo.getValue(), EnumSituacao.ATIVO.getValue());

        EnumSituacao inativo = EnumSituacao.valueOf("INATIVO");
        Assert.assertEquals(inativo.getValue(), EnumSituacao.INATIVO.getValue());
    }
}
