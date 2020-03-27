package br.com.albus.comum.pessoa;

import br.com.albus.generic.SortPaginatorFilter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Example;

import java.util.HashMap;
import java.util.Map;


@Getter
@Setter
public class PessoaFilter extends SortPaginatorFilter {

    private Example<Pessoa> example;

    public PessoaFilter(HashMap<String, String> requestMap) {
        super((Map)requestMap);
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(requestMap.get("nome"));
        pessoa.setApelido(requestMap.get("apelido"));

        example = Example.of(pessoa);
    }
}