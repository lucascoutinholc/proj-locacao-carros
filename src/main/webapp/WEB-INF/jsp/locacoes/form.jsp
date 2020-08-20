<%-- 
    Document   : form
    Created on : 20/08/2020, 10:42:13
    Author     : lucascoutinho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="${linkTo[LocacoesController].salvar}" method="get">
            <input type="number" name="locacao.id_locacao" hidden value="${locacao.id_locacao}">

            Data de início: <input type="text" name="locacao.dataInicio" value="${locacao.dataInicio}">

            Data de fim: <input type="text" name="locacao.dataFim" value="${locacao.dataFim}">

            <input type="number" name="locacao.qtdDiarias" placeholder="Quantidade de diárias" value="${locacao.qtdDiarias}">

            Cliente:
            <select name="locacao.cliente.id_cliente">
                <option value=""></option>
                <c:forEach items="${listaClientes}" var="clientes">
                    <option value="${clientes.id_cliente}"> ${clientes.nome} </option>
                </c:forEach>
            </select>

            Veiculo:
            <select name="locacao.veiculo.id_veiculo">
                <option value=""></option>
                <c:forEach items="${listaVeiculos}" var="veiculos">
                    <option value="${veiculos.id_veiculo}" name> ${veiculos.modelo} </option>
                </c:forEach>
            </select>

            <input type="submit" value="Cadastrar">
        </form>
    </body>
</html>
