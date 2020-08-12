<%-- 
    Document   : lista
    Created on : 11/08/2020, 16:15:48
    Author     : Lucas Coutinho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Lista de Clientes </title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th> ID </th>
                    <th> Nome </th>
                    <th> Telefone </th>
                    <th colspan="2"> Opções </th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${clienteList}" var="cliente">
                    <tr>
                        <td> ${cliente.id_cliente} </td>
                        <td> ${cliente.nome} </td>
                        <td> ${cliente.telefone} </td>
                        <td> <a href="${linkTo[ClientesController].editar}?id=${cliente.id_cliente}"> Editar </a> </td>
                        <td> <a href="${linkTo[ClientesController].excluir}?id=${cliente.id_cliente}"> Excluir </a> </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
