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

        <title> Cadastro de Clientes </title>
    </head>

    <body>
        <%@include file="../template/header.jsp"%>

        <form action="${linkTo[ClientesController].salvar}" method="get" class="text-center border border-light p-5">
            <p class="h4 mb-4"> Cadastro </p>

            <input type="number" name="cliente.id_cliente" hidden value="${cliente.id_cliente}" class="form-control mb-4">

            <input type="text" name="cliente.nome" placeholder="Nome" value="${cliente.nome}" class="form-control mb-4">

            <input type="text" name="cliente.telefone" placeholder="Telefone" value="${cliente.telefone}"
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