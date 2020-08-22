package com.projeto.site.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import com.projeto.site.model.dao.VeiculoDao;
import com.projeto.site.model.entity.Veiculo;
import java.util.List;
import javax.inject.Inject;

@Controller
public class VeiculosController {
    
    @Inject
    private VeiculoDao vDao;
    
    @Inject
    private Result result;
    
    @Inject
    private Validator validator;
    
    public void form() {
    }
    
    public void salvar(Veiculo veiculo) {
        validator.validate(veiculo);
        validator.onErrorRedirectTo(this).form();
        
        if (veiculo.getId_veiculo() == null) {
            vDao.salvar(veiculo);
        } else {
            vDao.atualizar(veiculo);
        }
        
        result.redirectTo(this).lista();
    }
    
    public void editar(Long id) {
        Veiculo encontrado = vDao.buscarVeiculo(id);
        result.include(encontrado);
        
        result.of(this).form();
        
    }
    
    public void excluir(Long id) {
        vDao.excluir(id);
        
        result.redirectTo(this).lista();
    }
    
    public List<Veiculo> lista() {
        return vDao.listarVeiculos();
    }
}
