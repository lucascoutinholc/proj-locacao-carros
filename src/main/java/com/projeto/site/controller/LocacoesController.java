package com.projeto.site.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import com.projeto.site.model.dao.ClienteDao;
import com.projeto.site.model.dao.LocacaoDao;
import com.projeto.site.model.dao.VeiculoDao;
import com.projeto.site.model.entity.Cliente;
import com.projeto.site.model.entity.Locacao;
import com.projeto.site.model.entity.Veiculo;
import java.util.List;

@Controller
public class LocacoesController {
    
    LocacaoDao lDao = new LocacaoDao();
    
    ClienteDao cDao = new ClienteDao();
    
    VeiculoDao vDao = new VeiculoDao();
    
    public void form(Result result) {
        List<Cliente> listaDeClientes = cDao.listarClientes();
        List<Veiculo> listaDeVeiculos = vDao.listarVeiculos();
        
        result.include("listaClientes", listaDeClientes);
        result.include("listaVeiculos", listaDeVeiculos);
    }
    
    //Adicionar: salvar, editar e excluir
    
    public void salvar(Locacao locacao, Result result) {
        System.out.println(locacao.toString());
        
        if (locacao.getId_locacao() == null) {
            lDao.salvar(locacao);
        } else {
            lDao.atualizar(locacao);
        }
        
        result.redirectTo(this).lista();
    }
    
    public void editar(Long id, Result result) {
        Locacao encontrado = lDao.buscarLocacao(id);
        result.include(encontrado);
        
        result.redirectTo(this).form(result);
    }
    
    public void excluir(Long id, Result result) {
        lDao.excluir(id);
        
        result.redirectTo(this).lista();
    }
    
    public List<Locacao> lista() {
        System.out.println(lDao.listarLocacoes());
        return lDao.listarLocacoes();
    }
}
