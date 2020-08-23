<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
              integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

        <title> Lista de Clientes </title>
    </head>

    <body>
        <%@include file="../template/header.jsp"%>

        <table class="table">
            <thead>
                <tr>
                    <th scope="col"> ID </th>
                    <th scope="col"> Nome </th>
                    <th scope="col"> Telefone </th>
                    <th colspan="2"> Opções </th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${clienteList}" var="cliente">
                    <tr>
                        <td scope="row"> ${cliente.id_cliente} </td>
                        <td> ${cliente.nome} </td>
                        <td> ${cliente.telefone} </td>
                        <td> <a href="${linkTo[ClientesController].editar}?id=${cliente.id_cliente}"> Editar </a> </td>
                        <td> <a href="${linkTo[ClientesController].excluir}?id=${cliente.id_cliente}"> Excluir </a> </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <%@include file="../template/footer.jsp"%>
    </body>

</html>