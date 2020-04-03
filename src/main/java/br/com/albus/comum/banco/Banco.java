package br.com.albus.comum.banco;

import br.com.albus.generic.GenericEntity;
import br.com.albus.generic.enums.EnumSituacao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_BANCO", schema = "public")
@AttributeOverride(name = "dataCadastro", column = @Column(name = "BC_DTHR_CADASTRO"))
@AttributeOverride(name = "dataAlteracao", column = @Column(name = "BC_DTHR_ALTERACAO"))
@AttributeOverride(name = "usuarioCadastro", column = @Column(name = "BC_USUARIO_CADASTRO"))
@AttributeOverride(name = "usuarioAlteracao", column = @Column(name = "BC_USUARIO_ALTERACAO"))
@Getter
@Setter
@NoArgsConstructor
public class Banco extends GenericEntity<Long> {

    @Id
    @Column(name = "BC_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "BC_CODIGO", nullable = false, length = 50)
    private String codigo;

    @Column(name = "BC_NOME", nullable = false, length = 75)
    private String nome;

    @Column(name = "BC_DESCRICAO")
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "BC_SITUACAO", nullable = false, length = 10)
    private EnumSituacao situacao;

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
