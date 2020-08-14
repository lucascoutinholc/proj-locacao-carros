package com.projeto.site.model.dao;

import com.projeto.site.model.entity.Cliente;
import com.projeto.site.util.JpaUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ClienteDao {

    EntityManager manager = JpaUtil.getEntityManager();

    public void salvar(Cliente cliente) {
        manager.getTransaction().begin();
        manager.persist(cliente);
        manager.getTransaction().commit();
    }

    public Cliente buscarCliente(Long id) {
        return manager.find(Cliente.class, id);
    }

    public List<Cliente> listarClientes() {
        Query query = manager.createQuery("from Cliente");
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
