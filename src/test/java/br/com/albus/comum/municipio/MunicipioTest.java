package br.com.albus.comum.municipio;

import br.com.albus.generic.GenericEntityTest;

public class MunicipioTest extends GenericEntityTest<Municipio, Long> {

    public MunicipioTest() {
        this.entityClass = Municipio.class;
        this.idClass = Long.class;
    }
}

