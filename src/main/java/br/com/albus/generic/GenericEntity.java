package br.com.albus.generic;

import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * Classe base para qualquer objeto serializável.
 *
 * @param <T> o tipo do atributo id
 * @author Eduardo Balan
 */
@MappedSuperclass
public abstract class GenericEntity<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = 1L;

    public abstract T getId();

    public abstract void setId(T id);

    //@JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dataCadastro;
    //@JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dataAlteracao;
    //@JsonIgnore
    protected String usuarioCadastro;
    //@JsonIgnore
    protected String usuarioAlteracao;

    public Date getDataCadastro() {
        return this.dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataAlteracao() {
        return this.dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public String getUsuarioCadastro() {
        return this.usuarioCadastro;
    }

    public void setUsuarioCadastro(String usuarioCadastro) {
        this.usuarioCadastro = usuarioCadastro;
    }

    public String getUsuarioAlteracao() {
        return this.usuarioAlteracao;
    }

    public void setUsuarioAlteracao(String usuarioAlteracao) {
        this.usuarioAlteracao = usuarioAlteracao;
    }

    /**
     * Indica quando outro objeto é igual a este. Nesta implementação, qualquer objeto derivado de
     * Bean é igual a este desde que seja exatamente da mesma classe e tenha o mesmo ID.
     *
     * @param obj o objeto a comparar com este
     * @return {@code true} se este objeto é igual ao do argumento; {@code false} caso contrário.
     * @author Eduardo Balan
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        GenericEntity x = (GenericEntity) obj;

        return getId() != null ? getId().equals(x.getId()) : x.getId() == null;
    }

    /**
     * Retorna um valor de hash code para este objeto.
     *
     * @return um valor de hash code para este objeto
     * @author Eduardo Balan
     */
    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
