package br.com.albus.comum.municipio;

import br.com.albus.comum.estado.Estado;
import br.com.albus.generic.GenericEntity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_MUNICIPIO", schema = "public")
@AttributeOverride(name = "dataCadastro", column = @Column(name = "MU_DTHR_CADASTRO"))
@AttributeOverride(name = "dataAlteracao", column = @Column(name = "MU_DTHR_ALTERACAO"))
@AttributeOverride(name = "usuarioCadastro", column = @Column(name = "MU_USUARIO_CADASTRO"))
@AttributeOverride(name = "usuarioAlteracao", column = @Column(name = "MU_USUARIO_ALTERACAO"))
public class Municipio extends GenericEntity<Long> {

    @Id
    @Column(name = "MU_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MU_NOME", length = 75, nullable = false)
    private String nome;

    @Column(name = "MU_ID_IBGE")
    private Long idIBGE;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UF_ID")
    private Estado estado;

    public Municipio() {
        //Construtor padrão
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdIBGE() {
        return idIBGE;
    }

    public void setIdIBGE(Long idIBGE) {
        this.idIBGE = idIBGE;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
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
