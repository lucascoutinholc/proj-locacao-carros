package com.projeto.site.model.dao;

import com.projeto.site.model.entity.Veiculo;
import com.projeto.site.util.JpaUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class VeiculoDao {
    
    EntityManager manager = JpaUtil.getEntityManager();
    
    public void salvar(Veiculo veiculo) {
        manager.getTransaction().begin();
        manager.persist(veiculo);
        manager.getTransaction().commit();
    }
    
    public Veiculo buscarVeiculo(Long id) {
        return manager.find(Veiculo.class, id);
    }
    
    public List<Veiculo> listarVeiculos() {
        Query query = manager.createQuery("from Veiculo");
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
