package com.projeto.site.model.dao;

import com.projeto.site.model.entity.Locacao;
import com.projeto.site.util.JpaUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class LocacaoDao {
    EntityManager manager = JpaUtil.getEntityManager();
    
    public void salvar(Locacao locacao) {
        manager.getTransaction().begin();
        manager.persist(locacao);
        manager.getTransaction().commit();
    }
    
    public Locacao buscarLocacao(Long id) {
        return manager.find(Locacao.class, id);
    }
    
    public List listarLocacoes() {
        Query query = manager.createQuery("from Locacao");
        return query.getResultList();
    }
    
    public void atualizar(Locacao locacao) {
        manager.getTransaction().begin();
        manager.merge(locacao);
        manager.getTransaction().commit();
    }
    
    public void excluir(Long id) {
        manager.getTransaction().begin();
        Locacao l = manager.find(Locacao.class, id);
        manager.remove(l);
        manager.getTransaction().commit();
    }
}
