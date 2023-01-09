<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="/WEB-INF/jsp/template/header.jsp"></jsp:include>

<div class="container">
   <div class="panel panel-primary">
    <div class="panel-heading"><h1>${projeto.id == null ? 'Novo' : 'Atualizar'} Projeto</h1></div>
    <hr>
    <div class="panel-body">
     <form:form action="${formAction}" method="POST" modelAttribute="projeto">
      <form:hidden path="id" />
      <c:if test="${projeto.id != null}">
        <form:hidden path="criadoEm" />
      </c:if>

      <div class="row g-3">
      <div class="col-md-6">
       <form:label path="nome">Nome</form:label>
       <form:input path="nome" type="text" class="form-control" required="required" />
       <form:errors path="nome" cssClass="text-warning" />
      </div>

      <div class="col-md-6">
         <form:label path="gerenteResponsavel">Gerente Responsável</form:label>
         <form:input path="gerenteResponsavel" type="text" class="form-control" required="required" />
         <form:errors path="gerenteResponsavel" cssClass="text-warning" />
      </div>
      </div>

      <div class="row g-3">
      <div class="col-md-6">
          <form:label path="dataInicio">Data de Início</form:label>
          <form:input path="dataInicio"
                      type="date"
                      class="form-control"
                      min="2000-01-01"
                      max="2100-01-01"
                      required="required" />
          <form:errors path="dataInicio" cssClass="text-warning" />
      </div>

      <div class="col-md-6">
        <form:label path="previsaoTermino">Previsão de Término</form:label>
        <form:input path="previsaoTermino"
                    type="date"
                    class="form-control"
                    min="2000-01-01"
                    max="2100-01-01"
                    required="required" />
        <form:errors path="previsaoTermino" cssClass="text-warning" />
      </div>
      </div>

      <div class="row g-3">
      <div class="col-md-3">
         <form:label path="orcamentoTotal">Orçamento Total</form:label>
         <form:input path="orcamentoTotal" type="number" class="form-control" required="required" />
         <form:errors path="orcamentoTotal" cssClass="text-warning" />
      </div>

      <div class="col-md-3">
          <form:label path="risco">Risco</form:label>
          <form:select path="risco" class="form-control">
              <form:option value="${null}">Selecione</form:option>
              <form:option value="BAIXO">
                Baixo Risco
              </form:option>
              <form:option value="MEDIO">
                Médio Risco
              </form:option>
              <form:option value="ALTO">
                Alto Risco
              </form:option>
          </form:select>
          <form:errors path="risco" cssClass="text-warning" />
      </div>

      <div class="col-md-6">
          <form:label path="descricao">Descrição</form:label>
          <form:input path="descricao" type="text" class="form-control" />
          <form:errors path="descricao" cssClass="text-warning" />
      </div>
      </div>

      <c:if test="${projeto.id != null}">
      <div class="row g-3">
      <div class="col-md-6">
           <form:label path="status">Status</form:label>
           <form:select path="status" class="form-control" required="required">
               <form:option value="${null}">Selecione</form:option>
               <form:option value="EM_ANALISE">
                  Em Análise
               </form:option>
               <form:option value="ANALISE_REALIZADA">
                  Análise Realizada
               </form:option>
               <form:option value="ANALISE_APROVADA">
                  Análise Aprovada
               </form:option>
               <form:option value="INICIADO">
                  Iniciado
               </form:option>
               <form:option value="PLANEJADO">
                  Planejado
               </form:option>
               <form:option value="EM_ANDAMENTO">
                  Em Andamento
               </form:option>
               <form:option value="ENCERRADO">
                  Encerrado
               </form:option>
               <form:option value="CANCELADO">
                  Cancelado
               </form:option>
           </form:select>
           <form:errors path="status" cssClass="text-warning" />
          </div>
          <div class="col-md-6">
                 <form:label path="dataTerminoReal">Data Término Real</form:label>
                 <form:input path="dataTerminoReal" type="date" class="form-control" />
                 <form:errors path="dataTerminoReal" cssClass="text-warning" />
          </div>
      </div>

      </c:if>
        <br>
      <div class="row">
          <div class="col-md-3" >
              <button type="submit" class="btn btn-success">${projeto.id == null ? 'Salvar' : 'Atualizar'}</button>
          </div>
      <div>

     </form:form>
    </div>
   </div>
</div>

<jsp:include page="/WEB-INF/jsp/template/footer.jsp"></jsp:include>