package com.projeto.site.model.dao;

import com.projeto.site.model.entity.Cliente;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Dependent
public class ClienteDao {

    @Inject
    EntityManager manager;

    public void salvar(Cliente cliente) {
        manager.getTransaction().begin();
        manager.persist(cliente);
        manager.getTransaction().commit();
    }

    public Cliente buscarCliente(Long id) {
        return manager.find(Cliente.class, id);
    }

    public List<Cliente> listarClientes() {
        Query query = manager.createQuery("select c from Cliente c");
        return query.getResultList();
    }

    public void atualizar(Cliente cliente) {
        manager.getTransaction().begin();
        manager.merge(cliente);
        manager.getTransaction().commit();
    }

    public void excluir(Long id) {
        manager.getTransaction().begin();
        Cliente c = manager.find(Cliente.class, id);
        manager.remove(c);
        manager.getTransaction().commit();
    }
}
