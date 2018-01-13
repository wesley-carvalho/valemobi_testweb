<%--     
    Author     : wesley oliveira de carvalho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Menu Principal</title>        
        <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    </head>
    <body>
        <c:import url="/WEB-INF/jsp/cabecalho.jsp" />

        <div class="jumbotron">
            <div class="container">
                <h1>Menu Principal</h1>
            </div>
        </div>

        <div class="container marketing">            
            <div class="row">
                <div class="col-lg-4">
                    <img class="img-circle" src="${pageContext.request.contextPath}/img/icone-cadastro.png" alt="cadastrar cliente" width="140" height="140">
                    <h2>Cadastrar Cliente</h2>
                    <p>Realizar cadastro de novos clientes no site.</p>                    
                    <p><a class="btn btn-default" href="${pageContext.request.contextPath}/menu_cadastro_de_clientes" role="button">View details &raquo;</a></p>
                </div><!-- /.col-lg-4 -->
                <div class="col-lg-4">
                    <img class="img-circle" src="${pageContext.request.contextPath}/img/icone-relatorio.png" alt="listar cliente" width="140" height="140">
                    <h2>Visualizar Cadastrados</h2>
                    <p>Visualizar perfil dos clientes cadastrados no site.</p>
                    <p><a class="btn btn-default" href="${pageContext.request.contextPath}/menu_lista_de_clientes" role="button">View details &raquo;</a></p>
                </div><!-- /.col-lg-4 -->
                <div class="col-lg-4">
                    <img class="img-circle" src="${pageContext.request.contextPath}/img/icone-financeirro.png" alt="corridas" width="140" height="140">
                    <h2>Corridas</h2>
                    <p>Cadastrar corridas e visualizar relatório de corridas registradas.</p>                    
                    <p><a class="btn btn-default" href="${pageContext.request.contextPath}/menu_cadastro_de_corridas" role="button">View details &raquo;</a></p>
                </div><!-- /.col-lg-4 -->
            </div><!-- /.row -->
        </div><!-- /.container -->

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/js/validator.min.js"></script>
    </body>
</html>
