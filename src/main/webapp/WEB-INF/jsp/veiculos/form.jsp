<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Formulário de Veículos </title>
    </head>
    <body>
        <form action="${linkTo[VeiculosController].salvar}" method="get">
            <input type="number" name="veiculo.id_veiculo" hidden value="${veiculo.id_veiculo}">

            <input type="text" name="veiculo.tipo" placeholder="Tipo" value="${veiculo.tipo}">

            <input type="text" name="veiculo.marca" placeholder="Marca" value="${veiculo.marca}">

            <input type="text" name="veiculo.modelo" placeholder="Modelo" value="${veiculo.modelo}">

            <input type="text" name="veiculo.ano" placeholder="Ano" value="${veiculo.ano}">

            <input type="text" name="veiculo.placa" placeholder="Placa" value="${veiculo.placa}">

            <input type="text" name="veiculo.valorDiaria" placeholder="Valor da Diária" value="${veiculo.valorDiaria}">

            <input type="submit" value="Cadastrar">
        </form>
    </body>
</html>
