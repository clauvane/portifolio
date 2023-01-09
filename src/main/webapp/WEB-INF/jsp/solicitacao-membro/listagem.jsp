<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/jsp/template/header.jsp"></jsp:include>

<div class="container">
 <div class="panel panel-primary">
  <div class="panel-heading">
  <br>
   <div>
    <a type="button" class="btn btn-primary btn-md" href="/portifolio/solicitacao-membro/salvar">Nova Solicitação de Membro</a>
   </div>
   <hr>
   <h3>Lista de Solicitações de Membros</h3>
  </div>
  <div class="panel-body">
   <table class="table table-striped">
    <thead>
     <tr>
      <th width="30%">Pessoa</th>
      <th width="30%">Projeto</th>
      <th width="20%">Status</th>
      <th width="20%">Ações</th>
     </tr>
    </thead>
    <tbody>
     <c:forEach items="${solicitacaoMembros}" var="solicitacaoMembro">
      <tr>
       <td>${solicitacaoMembro.pessoa.nome}</td>
       <td>${solicitacaoMembro.projeto.nome}</td>
       <td>${solicitacaoMembro.status}</td>

       <td>
       <c:if test = "${solicitacaoMembro.status == 'SOLICITADO'}">
           <a type="button" class="btn btn-success" href="/portifolio/solicitacao-membro/aprovar?id=${solicitacaoMembro.id}">Aprovar</a>
           &nbsp;
           <a type="button" class="btn btn-danger" href="/portifolio/solicitacao-membro/reprovar?id=${solicitacaoMembro.id}">Reprovar</a>
       </c:if>
        <c:if test = "${solicitacaoMembro.status == 'APROVADO'}">
           <a type="button" class="btn btn-success" href="/portifolio/solicitacao-membro/editar?id=${solicitacaoMembro.id}">Editar</a>

           <button type="button"
                   class="btn btn-danger"
                   data-bs-target="#removerModal"
                   data-bs-toggle="modal"
                   data-nome="A solicitação de membro da pessoa ${solicitacaoMembro.pessoa.nome} será removida."
                   data-link="/portifolio/solicitacao-membro/remover?id=${solicitacaoMembro.id}">
             Remover
           </button>
        </c:if>
       </td>
      </tr>
     </c:forEach>
    </tbody>
   </table>
  </div>
 </div>

<jsp:include page="/WEB-INF/jsp/template/footer.jsp"></jsp:include>