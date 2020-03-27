package br.com.albus.comum.pessoa;

import br.com.albus.generic.GenericController;
import br.com.albus.generic.exception.GenericRuntimeException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PessoaController extends GenericController <Pessoa, PessoaRepository, Long>{

    @Override
    public Pessoa inserir(Pessoa entityNova) {
        throw new GenericRuntimeException("Vc deve utilizar o recurso /pessoaFisica ou /pessoaJuridica", null);
    }

    @Override
    public Pessoa editar(Pessoa enditadeAEditar) {
        throw new GenericRuntimeException("Vc deve utilizar o recurso /pessoaFisica ou /pessoaJuridica", null);
    }
}