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

        <title>Cadastrar de Corrida</title>        
        <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    </head>
    <body>
        <c:import url="/WEB-INF/jsp/cabecalho.jsp" />

        <div class="jumbotron">
            <div class="container">
                <h1>Cadastrar Nova Corrida</h1>                
            </div>
        </div>

        <div class="container">
            <form class="form-horizontal" data-toggle="validator" action="${pageContext.request.contextPath}/corrida_cadastrar" method="post">
                <div class="form-group">
                    <label for="motorista" class="col-sm-2 control-label">Motorista*</label>
                    <div class="col-sm-10">
                        <select class="form-control" name="motorista" id="motorista" data-error="Selecione uma opção." required>
                            <option value="">Selecione um motorista</option>
                            <c:forEach items="${motoristas}" var="motorista">
                                <c:if test="${motorista.status == true}">
                                    <option value="<c:out value="${motorista.id}" />">
                                        <c:out value="${motorista.nome}" /> | <c:out value="${motorista.modelo_carro}" />
                                    </option>
                                </c:if>
                            </c:forEach>                            
                        </select>
                        <div class="help-block with-errors"></div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="passageiro" class="col-sm-2 control-label">Passageiro*</label>
                    <div class="col-sm-10">
                        <select class="form-control" name="passageiro" id="passageiro" data-error="Selecione uma opção." required>
                            <option value="">Selecione um passageiro</option>
                            <c:forEach items="${passageiros}" var="passageiro">
                                <option value="<c:out value="${passageiro.id}" />">
                                    <c:out value="${passageiro.nome}" />
                                </option>                                            
                            </c:forEach>
                        </select>
                        <div class="help-block with-errors"></div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="valor" class="col-sm-2 control-label">Valor*</label>
                    <div class="col-sm-4">
                        <div class="input-group">
                            <span class="input-group-addon">R$</span>
                            <input type="text" name="valor" class="form-control" id="valor" placeholder="123,00" data-error="Preencha este campo." required>
                            <div class="help-block with-errors"></div>
                        </div>
                    </div>
                </div>                

                <hr>

                <div class="form-row navbar-right col-md-4">                                
                    <div class="btn-group btn-group-justified" role="group">
                        <div class="btn-group" role="group">                                        
                            <button type="submit" class="btn btn-primary">Salvar</button>
                        </div>
                        <div class="btn-group" role="group">
                            <button type="reset" class="btn btn-primary">Limpar</button>
                        </div>
                        <div class="btn-group" role="group">
                            <a class="btn btn-primary" href="${pageContext.request.contextPath}/menu_cadastro_de_corridas">Cancelar</a>
                        </div>                        
                    </div>
                </div>
            </form>
        </div>

        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/js/validator.js" type="text/javascript"></script>        
    </body>
</html>
