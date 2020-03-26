package br.com.albus.comum.endereco;

import br.com.albus.generic.GenericEntityTest;
import org.junit.Assert;
import org.junit.Test;

public class EnderecoTest extends GenericEntityTest<Endereco, Long> {

    public EnderecoTest() {
        this.entityClass = Endereco.class;
        this.idClass = Long.class;
    }

    @Test
    public void EnumTipoEnderecolTest() {
        Endereco endereco = new Endereco();
        endereco.setTipoEndereco(EnumTipoEndereco.CASA);
        Assert.assertEquals("Casa", endereco.getTipoEndereco().getValue());

        endereco.setTipoEndereco(EnumTipoEndereco.TRABALHO);
        Assert.assertEquals("Trabalho",endereco.getTipoEndereco().getValue());

        endereco.setTipoEndereco(EnumTipoEndereco.FAZENDA);
        Assert.assertEquals("Fazenda",endereco.getTipoEndereco().getValue());

    }
}
