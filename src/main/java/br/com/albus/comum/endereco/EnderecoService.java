package br.com.albus.comum.endereco;

import br.com.albus.generic.GenericService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/albus/endereco")
public class EnderecoService extends GenericService<EnderecoController, Endereco, EnderecoRepository, Long> {

}
