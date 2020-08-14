<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Lista de Locações </title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th> ID </th>
                    <th> Data início </th>
                    <th> Data fim </th>
                    <th> Quantidade de diárias </th>
                    <th> Cliente </th>
                    <th> Veículo </th>
                    <th colspan="2"> Opções </th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${locacaoList}" var="locacao">
                    <tr>
                        <td> ${locacao.id_locacao} </td>
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
    </body>
</html>
