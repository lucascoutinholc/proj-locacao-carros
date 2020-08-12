/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.site.model.dao;

import com.projeto.site.jdbc.Conexao;
import com.projeto.site.model.entity.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas Coutinho
 */
public class ClienteDao {
    
    public void salvar(Cliente cliente) {
        try {
            Connection conexao = Conexao.criarConexao();
            
            String sql = "insert into tb_cliente (nome, telefone) values (?, ?)";
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getTelefone());
            
            if (ps.executeUpdate() == 1) {
                System.out.println("Os dados salvos com sucesso!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Os dados não foram salvos!");
    }
    
    public Cliente buscarCliente(int id) {
        try {
            Connection conexao = Conexao.criarConexao();

            String sql = "select * from tb_cliente where id_cliente=?";
            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            
            if (rs.first()) {
                Cliente c = new Cliente();
                
                c.setId_cliente(rs.getInt("id_cliente"));
                c.setNome(rs.getString("nome"));
                c.setTelefone(rs.getString("telefone"));
                
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public List<Cliente> listarClientes() {
        try {
            Connection conexao = Conexao.criarConexao();
            
            String sql = "select * from tb_cliente";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            List<Cliente> listaDeClientes = new ArrayList();
            
            while (rs.next()) {
                Cliente c = new Cliente();
                
                c.setId_cliente(rs.getInt("id_cliente"));
                c.setNome(rs.getString("nome"));
                c.setTelefone(rs.getString("telefone"));
                
                listaDeClientes.add(c);
            }
            
            return listaDeClientes;
        } catch (SQLException e) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return null;
    }
    
    public void atualizar(Cliente cliente) {
        try {
            Connection conexao = Conexao.criarConexao();
            
            String sql = "update tb_cliente set nome=?, telefone=? where id_cliente=?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getTelefone());
            ps.setInt(3, cliente.getId_cliente());
            
            if (ps.executeUpdate() == 1) {
                System.out.println("Os dados foram alterados com sucesso!");
            }
        } catch (SQLException e) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, e);
        }
        
        System.out.println("Os dados não foram alterados!");
    }
    
    public boolean excluir(int id) {
        try {
            Connection conexao = Conexao.criarConexao();
            
            String sql = "delete from tb_cliente where id_cliente=?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ps.setInt(1, id);
            
            if (ps.executeUpdate() == 1) {
                System.out.println("Os dados foram excluídos com sucesso!");
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, e);
        }
        
        System.out.println("Os dados não foram excluídos!");
        return false;
    }
}
