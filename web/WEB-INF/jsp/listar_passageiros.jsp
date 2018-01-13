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

        <title>Passageiros Cadastrados</title>        
        <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    </head>
    <body>
        <c:import url="/WEB-INF/jsp/cabecalho.jsp" />

        <div class="jumbotron">
            <div class="container">
                <h1>Passageiros Cadastrados</h1>
            </div>
        </div>

        <div class="container">
            <c:if test="${not empty msgErro}">
                <h2><c:out value="${msgErro}" /></h2>
            </c:if>

            <c:if test="${not empty passageiros}">
                <div class="table-responsive">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Nome</th>                                    
                                <th>CPF</th>
                                <th>Nascimento</th>
                                <th>Sexo</th>                            
                            </tr>
                        </thead>

                        <tbody>                                
                            <c:forEach items="${passageiros}" var="passageiro">                                
                                <tr>
                                    <td><c:out value="${passageiro.id}" /></td>
                                    <td><c:out value="${passageiro.nome}" /></td>
                                    <td><c:out value="${passageiro.cpf}" /></td>                                            
                                    <td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${passageiro.dt_nascimento}" /></td>
                                    <td><c:out value="${passageiro.sexo}" /></td>                                
                                    <td>
                                        <form action="${pageContext.request.contextPath}/passageiro_alterar" method="post">
                                            <input type="hidden" name="id" value="<c:out value="${passageiro.id}" />">

                                            <button class="btn btn-xs btn-warning" type="submit"><spam class="glyphicon glyphicon-pencil"></spam></button>
                                        </form>                                                                                               
                                    </td>
                                    <td>
                                        <form action="${pageContext.request.contextPath}/delete" method="post">
                                            <input type="hidden" name="way" value="/passageiro_excluir">
                                            <input type="hidden" name="id" value="<c:out value="${passageiro.id}" />">                                                    

                                            <button class="btn btn-xs btn-danger" type="submit"><spam class="glyphicon glyphicon-remove"></spam></button>
                                        </form>
                                    </td> 
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:if>
            <div class="form-row navbar-right col-md-2">                                
                <div class="btn-group btn-group-justified" role="group">
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/menu_lista_de_clientes">Voltar</a>                    
                </div>
            </div>
        </div>
    </body>
</html>
