package br.com.albus.comum.endereco;

import br.com.albus.comum.municipio.Municipio;
import br.com.albus.comum.pessoa.Pessoa;
import br.com.albus.generic.GenericEntity;

import javax.persistence.*;

@Entity
@Table(name = "TB_ENDERECO", schema = "public")
@AttributeOverride(name = "dataCadastro", column = @Column(name = "EN_DTHR_CADASTRO"))
@AttributeOverride(name = "dataAlteracao", column = @Column(name = "EN_DTHR_ALTERACAO"))
@AttributeOverride(name = "usuarioCadastro", column = @Column(name = "EN_USUARIO_CADASTRO"))
@AttributeOverride(name = "usuarioAlteracao", column = @Column(name = "EN_USUARIO_ALTERACAO"))
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
    public void setId(Long id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public EnumTipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(EnumTipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
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
