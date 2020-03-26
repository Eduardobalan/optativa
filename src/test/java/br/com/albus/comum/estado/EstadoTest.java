package br.com.albus.comum.estado;

import br.com.albus.generic.GenericEntityTest;

public class EstadoTest extends GenericEntityTest<Estado, Long> {

    public EstadoTest() {
        this.entityClass = Estado.class;
        this.idClass = Long.class;
    }
}

