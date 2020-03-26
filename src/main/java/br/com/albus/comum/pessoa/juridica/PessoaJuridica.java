package br.com.albus.comum.pessoa.juridica;

import br.com.albus.comum.pessoa.Pessoa;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DynamicUpdate
@Table(name = "TB_PESSOA_JURIDICA", schema = "public")
@DiscriminatorValue ("JURIDICA")
public class PessoaJuridica extends Pessoa {

	@Column(name = "PJ_CNPJ")
	private String cnpj;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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
