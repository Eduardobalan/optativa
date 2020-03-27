package br.com.albus.comum.pessoa;

import br.com.albus.generic.GenericController;
import br.com.albus.generic.exception.GenericRuntimeException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PessoaController extends GenericController <Pessoa, PessoaRepository, Long>{

    @Override
    public Pessoa inserir(Pessoa entityNova) {
        if(Objects.isNull(entityNova.getTipoPessoa())){
            throw new GenericRuntimeException("O campo tipoPessoa é obrigatorio (FISICA, JURIDICA)",null);
        }
        return super.inserir(entityNova);
    }
}