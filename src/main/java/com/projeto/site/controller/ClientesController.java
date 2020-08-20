package com.projeto.site.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import com.projeto.site.model.dao.ClienteDao;
import com.projeto.site.model.entity.Cliente;
import java.util.List;
import javax.inject.Inject;

@Controller
public class ClientesController {
    
    @Inject
    private ClienteDao cDao;
    
    @Inject
    private Result result;
    
    public void form() {
    }
    
    public void salvar(Cliente cliente) {        
        if (cliente.getId_cliente() == null) {
            cDao.salvar(cliente);
        } else {
            cDao.atualizar(cliente);
        }
        
        result.redirectTo(this).lista();
    }
    
    public void editar(Long id) {
        Cliente encontrado = cDao.buscarCliente(id);
        result.include(encontrado);
        
        result.of(this).form();
    }
    
    public void excluir(Long id) {
        cDao.excluir(id);
        
        result.redirectTo(this).lista();
    }
    
    public List<Cliente> lista() {
        return cDao.listarClientes();
    }
}