package br.com.albus.comum.estado;

import br.com.albus.comum.pais.Pais;
import br.com.albus.generic.GenericEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Table(name = "TB_ESTADO", schema = "public")
@AttributeOverride(name = "dataCadastro", column = @Column(name = "UF_DTHR_CADASTRO"))
@AttributeOverride(name = "dataAlteracao", column = @Column(name = "UF_DTHR_ALTERACAO"))
@AttributeOverride(name = "usuarioCadastro", column = @Column(name = "UF_USUARIO_CADASTRO"))
@AttributeOverride(name = "usuarioAlteracao", column = @Column(name = "UF_USUARIO_ALTERACAO"))
@Getter
@Setter
@NoArgsConstructor
public class Estado extends GenericEntity<Long> {

    @Id
    @Column(name = "UF_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "UF_NOME", length = 75, nullable = false)
    private String nome;

    @Column(name = "UF_SIGLA", length = 2, nullable = false)
    private String sigla;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PA_ID")
    private Pais pais;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
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
