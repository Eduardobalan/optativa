package br.com.albus.comum.pessoa.fisica;

import br.com.albus.generic.GenericEntityTest;

public class PessoaFisicaTest extends GenericEntityTest<PessoaFisica, Long> {

    public PessoaFisicaTest() {
        this.entityClass = PessoaFisica.class;
        this.idClass = Long.class;
    }
}
