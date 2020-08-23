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

        <title> Lista de Veículos </title>
    </head>

    <body>
        <%@include file="../template/header.jsp"%>

        <table class="table">
            <thead>
                <tr>
                    <th scope="col"> ID </th>
                    <th scope="col"> Tipo </th>
                    <th scope="col"> Marca </th>
                    <th scope="col"> Modelo </th>
                    <th scope="col"> Ano </th>
                    <th scope="col"> Placa </th>
                    <th scope="col"> Valor da diária </th>
                    <th colspan="2"> Opções </th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${veiculoList}" var="veiculo">
                    <tr>
                        <td scope="row"> ${veiculo.id_veiculo} </td>
                        <td> ${veiculo.tipo} </td>
                        <td> ${veiculo.marca} </td>
                        <td> ${veiculo.modelo} </td>
                        <td> ${veiculo.ano} </td>
                        <td> ${veiculo.placa} </td>
                        <td> ${veiculo.valorDiaria} </td>
                        <td> <a href="${linkTo[VeiculosController].editar}?id=${veiculo.id_veiculo}"> Editar </a> </td>
                        <td> <a href="${linkTo[VeiculosController].excluir}?id=${veiculo.id_veiculo}"> Excluir </a> </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <%@include file="../template/footer.jsp"%>
    </body>

</html>