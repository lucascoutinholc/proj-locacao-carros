package com.projeto.site.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import com.projeto.site.model.dao.ClienteDao;
import com.projeto.site.model.entity.Cliente;
import java.util.List;

@Controller
public class ClientesController {
    private ClienteDao cDao = new ClienteDao();
    
    public void form() {
        System.out.println(cDao);
    }
    
    public void salvar(Cliente cliente, Result result) {
        System.out.println(cliente.toString());
        
        if (cliente.getId_cliente() == null) {
            cDao.salvar(cliente);
        } else {
            cDao.atualizar(cliente);
        }
        
        result.redirectTo(this).lista();
    }
    
    public void editar(Long id, Result result) {
        Cliente encontrado = cDao.buscarCliente(id);
        result.include(encontrado);
        
        result.of(this).form();
    }
    
    public void excluir(Long id, Result result) {
        cDao.excluir(id);
        
        result.redirectTo(this).lista();
    }
    
    public List<Cliente> lista() {
        System.out.println(cDao);
        return cDao.listarClientes();
    }
}