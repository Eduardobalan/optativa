package br.com.albus.comum.pessoa;

import br.com.albus.generic.GenericService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/albus/pessoa")
@CrossOrigin
public class PessoaService extends GenericService<PessoaController, Pessoa, PessoaRepository, Long> {

}
