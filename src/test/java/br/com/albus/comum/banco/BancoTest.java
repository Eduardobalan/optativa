package br.com.albus.comum.banco;

import br.com.albus.generic.GenericEntityTest;

public class BancoTest extends GenericEntityTest<Banco, Long> {

    public BancoTest() {
        this.entityClass = Banco.class;
        this.idClass = Long.class;
    }
}

