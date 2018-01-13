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

        <title>Alteração Perfil Motorista</title>        
        <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    </head>
    <body>
        <c:import url="/WEB-INF/jsp/cabecalho.jsp" />

        <div class="jumbotron">
            <div class="container">
                <h1>Alteração Perfil Motorista</h1>
            </div>
        </div>

        <c:if test="${not empty motorista}">
            <div class="container">
                <form class="form-horizontal" data-toggle="validator" action="motorista_atualizar" method="post">
                    <input type="hidden" name="id" value="<c:out value="${motorista.id}" />">

                    <div class="form-group">
                        <label for="nome_completo" class="col-sm-2 control-label">Nome Completo*</label>
                        <div class="col-sm-10">
                            <input type="text" name="nome_completo" value="<c:out value="${motorista.nome}" />" class="form-control" id="nome_completo" placeholder="Nome Completo" data-error="Preencha este campo." required autofocus>
                            <div class="help-block with-errors"></div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="dt_nascimento" class="col-sm-2 control-label">Data de nascimento*</label>
                        <div class="col-sm-4">
                            <input type="date" name="dt_nascimento" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${motorista.dt_nascimento}" />" class="form-control" id="dt_nascimento" data-error="Preencha este campo." required>
                            <div class="help-block with-errors"></div>
                        </div>

                        <label for="cpf" class="col-sm-2 control-label">CPF*</label>
                        <div class="col-sm-4">
                            <input type="text" name="cpf" value="<c:out value="${motorista.cpf}" />" class="form-control" id="cpf" placeholder="444.333.222-11" data-error="Preencha este campo." required>
                            <div class="help-block with-errors"></div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="sexo" class="col-sm-2 control-label">Sexo*</label>
                        <div class="col-sm-4">
                            <select class="form-control" name="sexo" id="sexo" data-error="Selecione uma opção." required>                                
                                <option value="">Selecione uma opção</option>
                                <option value="masculino" <c:out value="${motorista.sexo == 'masculino' ? 'selected':''}" />>Masculino</option>
                                <option value="feminino" <c:out value="${motorista.sexo == 'feminino' ? 'selected':''}" />>Feminino</option>
                            </select>
                            <div class="help-block with-errors"></div>
                        </div>
                    </div>

                    <hr>

                    <div class="form-group">
                        <label for="modelo_carro" class="col-sm-2 control-label">Modelo do Carro*</label>
                        <div class="col-sm-4">
                            <input type="text" name="modelo_carro" value="<c:out value="${motorista.modelo_carro}" />" class="form-control" id="modelo_carro" placeholder="Toyota Corolla" data-error="Preencha este campo." required>
                            <div class="help-block with-errors"></div>
                        </div>

                        <label for="status" class="col-sm-2 control-label">Status*</label>
                        <div class="col-sm-4">
                            <select class="form-control" name="status" id="status" data-error="Selecione uma opção." required>
                                <option value="">Selecione uma opção</option>                                
                                <option value="true" <c:out value="${motorista.status == 'true' ? 'selected':''}" />>Ativo</option>
                                <option value="false" <c:out value="${motorista.status == 'false' ? 'selected':''}" />>Inativo</option>                                
                            </select>
                            <div class="help-block with-errors"></div>
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
                                <a class="btn btn-primary" href="${pageContext.request.contextPath}/listar_motoristas">Cancelar</a>
                            </div>                        
                        </div>
                    </div>
                </form>
            </div>
        </c:if>

        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/js/validator.js" type="text/javascript"></script>
    </body>
</html>
