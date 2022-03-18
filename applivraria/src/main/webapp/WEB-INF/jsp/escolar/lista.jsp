<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="edu.infnet.applivraria.model.domain.Aluno"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Booked</title>
</head>

<body>
	<c:import url="/WEB-INF/jsp/menu.jsp" />

	<div class="container">
	
		<h4>Cadastramento de livros escolares:</h4>

		<form action="/escolar" method="get">
			<button type="submit">Novo livro escolar</button>
		</form>
		
 		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">
				<strong>Confirmação!</strong> ${mensagem}
			</div>
		</c:if>

		

		<c:if test="${not empty escolarLista}">
			<p>Quantidade de livros escolares cadastrados: ${escolarLista.size()}</p>
			<table class="table table-dark table-striped">
				<thead>
					<tr>
						<th>Id</th>
						<th>Título</th>
						<th>Autor</th>
						<th>Qtd. de Páginas</th>
						<th>Valor</th>
						<th>Disciplina</th>
						<th>Série</th>
						<th>Tem Respostas</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="e" items="${escolarLista}">

						<tr>
							<td>${e.id}</td>
							<td>${e.titulo}</td>
							<td>${e.autor}</td>
							<td>${e.qtdePaginas}</td>
							<td>${e.valor}</td>
							<td>${e.disciplina}</td>
							<td>${e.serie}</td>
							<td>${e.temRespostas}</td>
							<th><a href="/escolar/${e.id}/excluir">Excluir</a></th>
						</tr>
					</c:forEach>

				</tbody>
				<tfoot>
					<tr>
						<th>Id</th>
						<th>Título</th>
						<th>Autor</th>
						<th>Qtd. de Páginas</th>
						<th>Valor</th>
						<th>Disciplina</th>
						<th>Série</th>
						<th>Tem Respostas</th>
						<th></th>
					</tr>
				</tfoot>
			</table>

		</c:if>

		<c:if test="${empty escolarLista}">
			<p>Não existem livros escolares cadastrados!!!</p>
		</c:if>

	</div>
</body>
</html>
