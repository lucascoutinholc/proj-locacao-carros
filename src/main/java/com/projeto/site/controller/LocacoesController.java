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
import javax.inject.Inject;

@Controller
public class LocacoesController {
    
    @Inject
    private LocacaoDao lDao;
    
    @Inject
    private ClienteDao cDao;
    
    @Inject
    private VeiculoDao vDao;
    
    @Inject
    private Result result;
    
    public void form() {
        List<Cliente> listaDeClientes = cDao.listarClientes();
        List<Veiculo> listaDeVeiculos = vDao.listarVeiculos();
        
        result.include("listaClientes", listaDeClientes);
        result.include("listaVeiculos", listaDeVeiculos);
    }
    
    public void salvar(Locacao locacao) {        
        if (locacao.getId_locacao() == null) {
            lDao.salvar(locacao);
        } else {
            lDao.atualizar(locacao);
        }
        
        result.redirectTo(this).lista();
    }
    
    public void editar(Long id) {
        Locacao encontrado = lDao.buscarLocacao(id);
        result.include(encontrado);
        
        result.redirectTo(this).form();
    }
    
    public void excluir(Long id) {
        lDao.excluir(id);
        
        result.redirectTo(this).lista();
    }
    
    public List<Locacao> lista() {
        return lDao.listarLocacoes();
    }
}
