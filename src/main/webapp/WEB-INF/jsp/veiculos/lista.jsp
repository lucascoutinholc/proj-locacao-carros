<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Lista de Veículos </title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th> ID </th>
                    <th> Tipo </th>
                    <th> Marca </th>
                    <th> Modelo </th>
                    <th> Ano </th>
                    <th> Placa </th>
                    <th> Valor da diária </th>
                    <th colspan="2"> Opções </th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${veiculoList}" var="veiculo">
                    <tr>
                        <td> ${veiculo.id_veiculo} </td>
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
        
        <a href="${linkTo[LocacoesController].form}"> Ir para o formulário de Locação </a>
    </body>
</html>
