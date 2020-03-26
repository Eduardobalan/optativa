package br.com.albus.comum.pessoa;

import br.com.albus.generic.GenericService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/albus/pessoa")
public class PessoaService extends GenericService<PessoaController, Pessoa, PessoaRepository, Long> {

}
