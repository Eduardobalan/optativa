package br.com.albus.comum.pais;

import br.com.albus.generic.GenericEntityTest;

public class PaisTest extends GenericEntityTest<Pais, Long> {

    public PaisTest() {
        this.entityClass = Pais.class;
        this.idClass = Long.class;
    }
}

