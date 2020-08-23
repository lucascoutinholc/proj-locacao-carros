<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
              integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

        <title> Formulário de Veículos </title>
    </head>

    <body>
        <%@include file="../template/header.jsp"%>

        <form action="${linkTo[VeiculosController].salvar}" method="get" class="text-center border border-light p-5">
            <p class="h4 mb-4"> Cadastro </p>

            <input type="number" name="veiculo.id_veiculo" hidden value="${veiculo.id_veiculo}">

            <input type="text" name="veiculo.tipo" placeholder="Tipo" value="${veiculo.tipo}" class="form-control mb-4">

            <input type="text" name="veiculo.marca" placeholder="Marca" value="${veiculo.marca}" class="form-control mb-4">

            <input type="text" name="veiculo.modelo" placeholder="Modelo" value="${veiculo.modelo}"
                   class="form-control mb-4">

            <input type="text" name="veiculo.ano" placeholder="Ano" value="${veiculo.ano}" class="form-control mb-4">

            <input type="text" name="veiculo.placa" placeholder="Placa" value="${veiculo.placa}" class="form-control mb-4">

            <input type="text" name="veiculo.valorDiaria" placeholder="Valor da Diária" value="${veiculo.valorDiaria}"
                   class="form-control mb-4">

            <input type="submit" value="Cadastrar"
                   class="btn btn-outline-info btn-rounded btn-block my-4 waves-effect z-depth-0">
        </form>

        <c:forEach var="error" items="${errors}">
            ${error.message} <br>
        </c:forEach>

        <%@include file="../template/footer.jsp"%>
    </body>

</html>