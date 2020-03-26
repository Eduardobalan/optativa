package br.com.albus.generic;

import br.com.albus.generic.exception.GenericRuntimeException;
import br.com.albus.generic.exception.GenericSqlInexistenteRuntimeException;
import br.com.albus.generic.exception.GenericSqlRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class GenericController é a classe responsável  por regras de negocio, genéricos e simples como:
 * Inserção em uma base de dados, remoção da base de dados, e update.
 *
 * @param <E></E> Entidade a qual ela ira prestar o servico.
 * @param <R></R> Repositorio responsavel pela E que vc esta utilizando.
 * @param <I>     IdType ou tipo do atributo id
 * @author Eduardo Balan
 */
@MappedSuperclass
public class GenericController<
        E extends GenericEntity<I>,
        R extends GenericRepository<E, I>,
        I extends Serializable> {

    /* Repositorio responsavel pela Entity */
    @Autowired
    private R repository;

    private static final String REGISTRO_NAO_ENCONTRADO = "Registro não encontrado na base de dados.";

    /**
     * Metodo responsável pelas regras de negocio genéricas da inserção.
     *
     * @param <E></E> Entidade que sera persistida no banco de dados.
     * @throws GenericSqlRuntimeException return Entity persistida no banco de dados.
     * @author Eduardo Balan
     */
    public E inserir(E entityNova) {
        try {
            return repository.save(entityNova);
        } catch (Exception e) {
            throw new GenericSqlRuntimeException("Erro ao inserir registro no Banco de Dados.", e);
        }
    }

    /**
     * Metodo responsável por validar regras de negocio genéricas da inserção.
     *
     * @param <E></E> Entidade que sera persistida no banco de dados.
     * @throws GenericSqlRuntimeException return Entity persistida no banco de dados.
     * @author Eduardo Balan
     */
    public E inserirComValidacao(E entityNova) {
        if (Objects.nonNull(entityNova.getId())) {
            throw new GenericRuntimeException("Objeto possui id e não pode ser Inserido.", null);
        }

        return inserir(entityNova);
    }

    /**
     * Metodo responsável pelas regras de negocio genéricas da edição.
     *
     * @param <E></E> entidade que sera atualizada.
     * @throws GenericSqlInexistenteRuntimeException
     * @throws GenericSqlRuntimeException            return void.
     * @author Eduardo Balan
     */
    public E editar(E enditadeAEditar) {
        try {
            return repository.saveAndFlush(enditadeAEditar);
        } catch (Exception e) {
            throw new GenericSqlRuntimeException(e);
        }
    }

    /**
     * Metodo responsável pelas regras de negocio genéricas da edição e verificação dos ids
     *
     * @param <E></E> entidade que sera atualizada.
     * @throws GenericSqlInexistenteRuntimeException
     * @throws GenericSqlRuntimeException            return void.
     * @author Eduardo Balan
     */
    public E editarComValidacao(E enditadeAEditar, I idUrl) {
        if (Objects.isNull(enditadeAEditar.getId())) {
            throw new GenericRuntimeException("Objeto não possui id para edição.", null);
        }

        if (!enditadeAEditar.getId().equals(idUrl)) {
            throw new GenericRuntimeException("Id do Objeto difere da url Id", null);
        }

        if (!repository.existsById(enditadeAEditar.getId())) {
            throw new GenericSqlInexistenteRuntimeException(REGISTRO_NAO_ENCONTRADO);
        }
        return editar(enditadeAEditar);
    }

    /**
     * Metodo responsável pelas regras de negocio genéricas da exclusão.
     *
     * @param <I></I> id da entidade que sera removida do banco de dados.
     * @throws GenericSqlInexistenteRuntimeException
     * @throws GenericSqlRuntimeException            return void.
     * @author Eduardo Balan
     */
    public void excluir(I idEntity) {
        if (!repository.existsById(idEntity)) {
            Logger.getGlobal().log(Level.SEVERE, REGISTRO_NAO_ENCONTRADO);
            throw new GenericSqlInexistenteRuntimeException(REGISTRO_NAO_ENCONTRADO, null);
        }

        try {
            repository.deleteById(idEntity);
        } catch (DataIntegrityViolationException e) {
            throw new GenericSqlRuntimeException("Não é possível realizar a exclusão. O registro possui relacionamentos no sistema.", e);
        } catch (Exception e) {
            throw new GenericSqlRuntimeException(e);
        }

    }

}