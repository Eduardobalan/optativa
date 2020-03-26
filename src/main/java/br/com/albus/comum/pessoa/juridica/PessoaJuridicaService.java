package br.com.albus.comum.pessoa.juridica;

import br.com.albus.generic.GenericService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/albus/pessoaJuridica")
public class PessoaJuridicaService extends GenericService<PessoaJuridicaController, PessoaJuridica, PessoaJuridicaRepository, Long> {

}
