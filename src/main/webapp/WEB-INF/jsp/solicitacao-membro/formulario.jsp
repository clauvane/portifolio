<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="/WEB-INF/jsp/template/header.jsp"></jsp:include>

<div class="container">
   <div class="panel panel-primary">
    <div class="panel-heading"><h1>${solicitacaoMembro.id == null ? 'Nova' : 'Atualizar'} Solicitação de Membro</h1></div>
    <hr>
    <div class="panel-body">
     <form:form action="${formAction}" method="POST" modelAttribute="solicitacaoMembro">
      <form:hidden path="id" />
      <c:if test="${solicitacaoMembro.id != null}">
        <form:hidden path="criadoEm" />
        <form:hidden path="status" />
      </c:if>

      <div class="row g-3">
        <div class="col-md-6">
            <form:label path="projeto.id">Projeto</form:label>
            <form:select path="projeto.id" class="form-control" required="required">
                <form:option value="${null}">Selecione</form:option>
                <c:forEach items="${projetos}" var="projeto">
                    <form:option value="${projeto.id}">${projeto.nome}</form:option>
                </c:forEach>
            </form:select>
            <form:errors path="projeto.id" cssClass="text-warning" />
        </div>
        <div class="col-md-6">
            <form:label path="pessoa.id">Pessoa</form:label>
            <form:select path="pessoa.id" class="form-control" required="required">
                <form:option value="${null}">Selecione</form:option>
                <c:forEach items="${pessoas}" var="pessoa">
                    <form:option value="${pessoa.id}">${pessoa.nome}</form:option>
                </c:forEach>
            </form:select>
            <form:errors path="pessoa.id" cssClass="text-warning" />
        </div>
      </div>
      <br>
      <div class="row">
          <div class="col-md-3" >
              <button type="submit" class="btn btn-primary">${solicitacaoMembro.id == null ? 'Salvar' : 'Atualizar'}</button>
          </div>
      <div>

     </form:form>
    </div>
   </div>
</div>

<jsp:include page="/WEB-INF/jsp/template/footer.jsp"></jsp:include>