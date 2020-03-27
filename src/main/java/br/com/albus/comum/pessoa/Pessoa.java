package br.com.albus.comum.pessoa;

import br.com.albus.generic.GenericEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@DynamicUpdate
@Table(name = "TB_PESSOA", schema = "public")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "PS_TIPO_PESSOA", length = 20)
@DiscriminatorValue("PESSOA")
@AttributeOverride(name = "dataCadastro", column = @Column(name = "PS_DTHR_CADASTRO"))
@AttributeOverride(name = "dataAlteracao", column = @Column(name = "PS_DTHR_ALTERACAO"))
@AttributeOverride(name = "usuarioCadastro", column = @Column(name = "PS_USUARIO_CADASTRO"))
@AttributeOverride(name = "usuarioAlteracao", column = @Column(name = "PS_USUARIO_ALTERACAO"))
@Getter
@Setter
@NoArgsConstructor
public class Pessoa extends GenericEntity<Long> {

    @Id
    @Column(name = "PS_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PS_TIPO_PESSOA", insertable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private ETipoPessoa tipoPessoa;

    @Column(name = "PS_NOME", nullable = false)
    private String nome;

    @Column(name = "PS_APELIDO")
    private String apelido;

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
