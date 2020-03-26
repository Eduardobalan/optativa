package br.com.albus.comum.pessoa.fisica;

import br.com.albus.comum.pessoa.Pessoa;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@DynamicUpdate
@Table(name = "TB_PESSOA_FISICA", schema = "public")
@DiscriminatorValue ("FISICA")
public class PessoaFisica extends Pessoa {

	@Column(name = "PF_CPF")
	private String cpf;

	@Column(name = "PF_RG")
	private String rg;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
