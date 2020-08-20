package com.projeto.site.model.dao;

import com.projeto.site.model.entity.Veiculo;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Dependent
public class VeiculoDao {
    
    @Inject
    EntityManager manager;
    
    public void salvar(Veiculo veiculo) {
        manager.getTransaction().begin();
        manager.persist(veiculo);
        manager.getTransaction().commit();
    }
    
    public Veiculo buscarVeiculo(Long id) {
        return manager.find(Veiculo.class, id);
    }
    
    public List<Veiculo> listarVeiculos() {
        Query query = manager.createQuery("select v from Veiculo v");
        //List<Veiculo> listaDeVeiculos = query.getResultList();
        return query.getResultList();
    }
    
    public void atualizar(Veiculo veiculo) {
        manager.getTransaction().begin();
        manager.merge(veiculo);
        manager.getTransaction().commit();
    }
    
    public void excluir(Long id) {
        manager.getTransaction().begin();
        Veiculo v = manager.find(Veiculo.class, id);
        manager.remove(v);
        manager.getTransaction().commit();
    }
}
