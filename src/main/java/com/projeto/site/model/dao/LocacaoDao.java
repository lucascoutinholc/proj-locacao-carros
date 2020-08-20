package com.projeto.site.model.dao;

import com.projeto.site.model.entity.Locacao;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Dependent
public class LocacaoDao {
    
    @Inject
    EntityManager manager;
    
    public void salvar(Locacao locacao) {
        manager.getTransaction().begin();
        manager.persist(locacao);
        manager.getTransaction().commit();
    }
    
    public Locacao buscarLocacao(Long id) {
        return manager.find(Locacao.class, id);
    }
    
    public List<Locacao> listarLocacoes() {
        Query query = manager.createQuery("select l from Locacao l", Locacao.class);
        List<Locacao> listaDeLocacoes = query.getResultList();
        return listaDeLocacoes;
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
