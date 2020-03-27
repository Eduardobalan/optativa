package br.com.albus.comum.pessoa.fisica;

import br.com.albus.comum.pessoa.Pessoa;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@DynamicUpdate
@Table(name = "TB_PESSOA_FISICA", schema = "public")
@DiscriminatorValue ("FISICA")
@Getter
@Setter
@NoArgsConstructor
public class PessoaFisica extends Pessoa {

	@Column(name = "PF_CPF")
	private String cpf;

	@Column(name = "PF_RG")
	private String rg;

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
