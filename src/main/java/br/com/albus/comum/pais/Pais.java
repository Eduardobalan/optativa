package br.com.albus.comum.pais;

import br.com.albus.generic.GenericEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PAIS", schema = "public")
@AttributeOverride(name = "dataCadastro", column = @Column(name = "PA_DTHR_CADASTRO"))
@AttributeOverride(name = "dataAlteracao", column = @Column(name = "PA_DTHR_ALTERACAO"))
@AttributeOverride(name = "usuarioCadastro", column = @Column(name = "PA_USUARIO_CADASTRO"))
@AttributeOverride(name = "usuarioAlteracao", column = @Column(name = "PA_USUARIO_ALTERACAO"))
@Getter
@Setter
@NoArgsConstructor
public class Pais extends GenericEntity<Long> {

    @Id
    @Column(name = "PA_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PA_NOME", nullable = false, length = 100)
    private String nome;

    @Column(name = "PA_NACIONALIDADE", nullable = false, length = 100)
    private String nacionalidade;

    @Column(name = "PA_SIGLA", length = 2)
    private String sigla;

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
