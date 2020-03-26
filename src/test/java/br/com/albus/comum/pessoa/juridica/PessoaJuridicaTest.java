package br.com.albus.comum.pessoa.juridica;

import br.com.albus.generic.GenericEntityTest;

public class PessoaJuridicaTest extends GenericEntityTest<PessoaJuridica, Long> {

    public PessoaJuridicaTest() {
        this.entityClass = PessoaJuridica.class;
        this.idClass = Long.class;
    }
}
