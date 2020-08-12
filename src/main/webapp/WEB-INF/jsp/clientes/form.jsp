<%-- 
    Document   : form
    Created on : 11/08/2020, 16:21:25
    Author     : Lucas Coutinho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Formulário de Clientes </title>
    </head>
    <body>
        <form action="${linkTo[ClientesController].salvar}" method="get">
            <input type="number" name="cliente.id_cliente" hidden value="${cliente.id_cliente}">

            <input type="text" name="cliente.nome" placeholder="Nome" value="${cliente.nome}">

            <input type="text" name="cliente.telefone" placeholder="Telefone" value="${cliente.telefone}">

            <input type="submit" value="Cadastrar">
        </form>
    </body>
</html>
