/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.site.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas Coutinho
 */
public class Conexao {
    
    public static void main(String[] args) {
        System.out.println(Conexao.criarConexao());
    }
    
    public static Connection criarConexao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String url = "jdbc:mysql://localhost:3306/bd_locacao_carros?serverTimezone=UTC&useSSL=false";
            String usuario = "root";
            String senha = "lukas123probrbd";
            
            return DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return null;
    }
}
