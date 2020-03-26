package br.com.albus.comum.pessoa;

import br.com.albus.generic.GenericEntityTest;

public class PessoaTest extends GenericEntityTest<Pessoa, Long> {

    public PessoaTest() {
        this.entityClass = Pessoa.class;
        this.idClass = Long.class;
    }
}
