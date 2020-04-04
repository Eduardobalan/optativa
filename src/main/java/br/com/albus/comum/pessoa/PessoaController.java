package br.com.albus.comum.pessoa;

import br.com.albus.generic.GenericController;
import br.com.albus.generic.exception.GenericRuntimeException;
import com.mysema.query.types.expr.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PessoaController extends GenericController<Pessoa, PessoaRepository, Long> {

    @Autowired
    private PessoaRepository repository;

    @Override
    public Pessoa inserir(Pessoa entityNova) {
        throw new GenericRuntimeException("Vc deve utilizar o recurso /pessoa/fisica ou /pessoa/juridica", null);
    }

    @Override
    public void excluir(Long idEntity) {
        throw new GenericRuntimeException("Não permitido Eduardo balan.", null);
    }

    @Override
    public Pessoa editar(Pessoa enditadeAEditar) {
        throw new GenericRuntimeException("Vc deve utilizar o recurso /pessoa/fisica ou /pessoa/juridica", null);
    }

}