package br.com.albus.generic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.List;

@MappedSuperclass
public class GenericService<
        C extends GenericController<E, R, I>,
        E extends GenericEntity<I>,
        R extends GenericRepository<E, I>,
        I extends Serializable> {

    /* Regras de servico da Entity.*/
    @Autowired
    private C business;

    /* Repositorio responsavel pela Entity.*/
    @Autowired
    private R repository;

    @GetMapping
    public List<E> buscarTodos() {
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Object buscarPorId(@PathVariable("id") I id) {
        return repository.findById(id);
    }

    @PostMapping
    public E inserir(@RequestBody E entitySalvar) {
        return business.inserirComValidacao(entitySalvar);
    }

    @PutMapping(path = "/{id}")
    public E editar(@RequestBody E entityUpdate, @PathVariable("id") I id) {
        return business.editarComValidacao(entityUpdate, id);
    }

    @DeleteMapping(path = "/{id}")
    public void excluir(@PathVariable("id") I id) {
        business.excluir(id);
    }
}
