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

        <title>Visualizar Clientes</title>        
        <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    </head>
    <body>
        <c:import url="/WEB-INF/jsp/cabecalho.jsp" />
        
        <div class="jumbotron">
            <div class="container">
                <h1>Visualizar Clientes</h1>               
            </div>           
        </div>

        <div class="container marketing">            
            <div class="row">
                <div class="col-lg-4">
                    <img class="img-circle" src="${pageContext.request.contextPath}/img/icone-relatorio.png" alt="listar passageiro" width="140" height="140">
                    <h2>Visualizar Passageiros</h2>
                    <p>Visualizar relatório de cadastro de passageiros.</p>                    
                    <p><a class="btn btn-default" href="${pageContext.request.contextPath}/listar_passageiros" role="button">View details &raquo;</a></p>
                </div><!-- /.col-lg-4 -->
                <div class="col-lg-4">
                    <img class="img-circle" src="${pageContext.request.contextPath}/img/icone-relatorio.png" alt="listar motorista" width="140" height="140">
                    <h2>Visualizar Motoristas</h2>
                    <p>Visualizar relatório de cadastro de motoristas.</p>
                    <p><a class="btn btn-default" href="${pageContext.request.contextPath}/listar_motoristas" role="button">View details &raquo;</a></p>
                </div><!-- /.col-lg-4 -->                
            </div><!-- /.row -->
        </div><!-- /.container -->
    </body>
</html>
