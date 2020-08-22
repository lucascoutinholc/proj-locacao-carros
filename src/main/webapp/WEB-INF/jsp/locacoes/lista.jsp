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
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <a class="navbar-brand" href="../index.jsp"> Início </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Cliente
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="${linkTo[ClientesController].form}"> Cadastrar </a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="${linkTo[ClientesController].lista}"> Listar clientes </a>
                        </div>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Veículo
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="${linkTo[VeiculosController].form}"> Cadastrar </a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="${linkTo[VeiculosController].lista}"> Listar veículos </a>
                        </div>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Locação
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="${linkTo[LocacoesController].form}"> Cadastrar </a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="${linkTo[LocacoesController].lista}"> Listar locações </a>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>

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

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
                integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
                integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
                integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
        crossorigin="anonymous"></script>
    </body>

</html>