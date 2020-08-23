package com.projeto.site.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import com.projeto.site.model.dao.ClienteDao;
import com.projeto.site.model.dao.LocacaoDao;
import com.projeto.site.model.dao.VeiculoDao;
import com.projeto.site.model.entity.Cliente;
import com.projeto.site.model.entity.Locacao;
import com.projeto.site.model.entity.Veiculo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    
    @Inject
    private Validator validator;
    
    public void form() {
        List<Cliente> listaDeClientes = cDao.listarClientes();
        List<Veiculo> listaDeVeiculos = vDao.listarVeiculos();
        
        result.include("listaClientes", listaDeClientes);
        result.include("listaVeiculos", listaDeVeiculos);
    }
    
    public void salvar(Locacao locacao) throws ParseException { 
        validator.validate(locacao);
        validator.onErrorRedirectTo(this).form();
        
        Long diasDeLocacao = (locacao.getDataFim().getTime() - locacao.getDataInicio().getTime())/(1000*60*60*24);  
        locacao.setQtdDiarias(diasDeLocacao);
        
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
        List<Cliente> listaDeClientes = cDao.listarClientes();
        List<Veiculo> listaDeVeiculos = vDao.listarVeiculos();
        
        result.include("listaClientes", listaDeClientes);
        result.include("listaVeiculos", listaDeVeiculos);
        
        return lDao.listarLocacoes();
    }
}
