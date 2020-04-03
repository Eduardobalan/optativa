package br.com.albus.comum.endereco;

import br.com.albus.comum.municipio.Municipio;
import br.com.albus.comum.pessoa.Pessoa;
import br.com.albus.generic.GenericEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TB_ENDERECO", schema = "public")
@AttributeOverride(name = "dataCadastro", column = @Column(name = "EN_DTHR_CADASTRO"))
@AttributeOverride(name = "dataAlteracao", column = @Column(name = "EN_DTHR_ALTERACAO"))
@AttributeOverride(name = "usuarioCadastro", column = @Column(name = "EN_USUARIO_CADASTRO"))
@AttributeOverride(name = "usuarioAlteracao", column = @Column(name = "EN_USUARIO_ALTERACAO"))
@Getter
@Setter
@NoArgsConstructor
public class Endereco extends GenericEntity<Long> {

    @Id
    @Column(name = "EN_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PS_ID")
    private Pessoa pessoa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MU_ID")
    private Municipio municipio;

    @Enumerated(EnumType.STRING)
    @Column(name = "EN_TIPO_ENDERECO")
    private EnumTipoEndereco tipoEndereco;

    @Column(name = "EN_LOGRADOURO")
    private String logradouro;

    @Column(name = "EN_NUMERO")
    private String numero;

    @Column(name = "EN_COMPLEMENTO")
    private String complemento;

    @Column(name = "EN_BAIRRO")
    private String bairro;

    @Column(name = "EN_REFERENCIA")
    private String referencia;

    @Override
    public Long getId() {
        return id;
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
