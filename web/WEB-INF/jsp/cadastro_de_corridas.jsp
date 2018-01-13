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

        <title>Cadastro de Corridas</title>        
        <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    </head>
    <body>
        <c:import url="/WEB-INF/jsp/cabecalho.jsp" />
        
        <div class="jumbotron">
            <div class="container">
                <h1>Cadastro e Relatório de Corridas</h1>               
            </div>           
        </div>

        <div class="container marketing">            
            <div class="row">
                <div class="col-lg-4">
                    <img class="img-circle" src="${pageContext.request.contextPath}/img/icone-cadastro.png" alt="cadastro corrida" width="140" height="140">
                    <h2>Cadastrar Nova Corrida</h2>
                    <p>Realizar cadastro de uma nova corrida.</p>                    
                    <p><a class="btn btn-default" href="${pageContext.request.contextPath}/cadastrar_corrida" role="button">View details &raquo;</a></p>
                </div><!-- /.col-lg-4 -->
                <div class="col-lg-4">
                    <img class="img-circle" src="${pageContext.request.contextPath}/img/icone-relatorio.png" alt="relatorio corrida" width="140" height="140">
                    <h2>Corridas Realizadas</h2>
                    <p>Visualizar relatório de corridas realizadas.</p>
                    <p><a class="btn btn-default" href="${pageContext.request.contextPath}/listar_corridas" role="button">View details &raquo;</a></p>
                </div><!-- /.col-lg-4 -->                
            </div><!-- /.row -->
        </div><!-- /.container -->
    </body>
</html>

