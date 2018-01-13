<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Excluir</title>
        <link href="bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <c:import url="cabecalho.jsp" />

        <div class="jumbotron">
            <div class="container notification">
                <h1><spam class="glyphicon glyphicon-trash"></spam> Excluir!</h1>
                <p>Deseja proseguir com a operação?</p>                              
                <div class="form-row">
                    <div class="btn-group">
                        <form action="${pageContext.request.contextPath}<c:out value="${way}" />" method="post">                    
                            <input type="hidden" name="id" value="<c:out value="${id}" />">                                             
                            <button type="submit" class="btn btn-primary">Continuar</button>
                        </form>                            
                    </div>
                    <div class="btn-group">
                        <a class="btn btn-primary" href="${pageContext.request.contextPath}/menu_lista_de_clientes">Cancelar</a>
                    </div>                        
                </div>
            </div><!--/.container-->            
        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    </body>
</html>
