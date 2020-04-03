package br.com.albus.comum.pessoa;

import br.com.albus.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/albus/pessoa")
public class PessoaService extends GenericService<PessoaController, Pessoa, PessoaRepository, Long> {

}
