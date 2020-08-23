<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
