package com.projeto.site.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import com.projeto.site.model.dao.VeiculoDao;
import com.projeto.site.model.entity.Veiculo;
import java.util.List;

@Controller
public class VeiculosController {
    private VeiculoDao vDao = new VeiculoDao();
    
    public void form() {
    }
    
    public void salvar(Veiculo veiculo, Result result) {
        if (veiculo.getId_veiculo() == null) {
            vDao.salvar(veiculo);
        } else {
            vDao.atualizar(veiculo);
        }
        
        result.redirectTo(this).lista();
    }
    
    public void editar(Long id, Result result) {
        Veiculo encontrado = vDao.buscarVeiculo(id);
        result.include(encontrado);
        
        result.of(this).form();
        
    }
    
    public void excluir(Long id, Result result) {
        vDao.excluir(id);
        
        result.redirectTo(this).lista();
    }
    
    public List<Veiculo> lista() {
        return vDao.listarVeiculos();
    }
}
