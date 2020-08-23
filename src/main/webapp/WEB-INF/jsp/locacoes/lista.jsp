<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
              integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

        <title> Lista de Locações </title>
    </head>

    <body>
        <%@include file="../template/header.jsp"%>

        <table class="table">
            <thead>
                <tr>
                    <th scope="col"> ID </th>
                    <th scope="col"> Data início </th>
                    <th scope="col"> Data fim </th>
                    <th scope="col"> Quantidade de diárias </th>
                    <th scope="col"> Cliente </th>
                    <th scope="col"> Veículo </th>
                    <th colspan="2"> Opções </th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${locacaoList}" var="locacao">
                    <tr>
                        <td scope="row"> ${locacao.id_locacao} </td>
                        <td> ${locacao.dataInicio} </td>
                        <td> ${locacao.dataFim} </td>
                        <td> ${locacao.qtdDiarias} </td>
                        <td> ${locacao.cliente.nome} </td>
                        <td> ${locacao.veiculo.modelo} </td>
                        <td> <a href="${linkTo[LocacoesController].editar}?id=${locacao.id_locacao}"> Editar </a> </td>
                        <td> <a href="${linkTo[LocacoesController].excluir}?id=${locacao.id_locacao}"> Excluir </a> </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <%@include file="../template/footer.jsp"%>
    </body>

</html>