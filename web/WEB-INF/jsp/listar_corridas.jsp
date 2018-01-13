<%--     
    Author     : wesley oliveira de carvalho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Corridas Realizadas</title>        
        <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    </head>
    <body>
        <c:import url="/WEB-INF/jsp/cabecalho.jsp" />

        <div class="jumbotron">
            <div class="container">
                <h1>Corridas Realizadas</h1>
            </div>
        </div>

        <div class="container">
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Passageiro</th>                                    
                            <th>Motorista</th>
                            <th>Veículo</th>
                            <th>Valor</th>                            
                        </tr>
                    </thead>
                    <tbody>                                
                        <c:forEach items="${corridas}" var="corrida">                                
                            <tr>
                                <td><c:out value="${corrida.id}" /></td>
                                <td><c:out value="${corrida.passageiro.nome}" /></td>
                                <td><c:out value="${corrida.motorista.nome}" /></td>                                
                                <td><c:out value="${corrida.motorista.modelo_carro}" /></td>                            
                                <td><fmt:formatNumber type="currency" value = "${corrida.valor}" /></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

            <div class="form-row navbar-right col-md-2">                                
                <div class="btn-group btn-group-justified" role="group">
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/menu_cadastro_de_corridas">Voltar</a>                    
                </div>
            </div>
        </div>
    </body>
</html>
