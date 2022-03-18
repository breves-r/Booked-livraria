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
	
		<h4>Cadastramento de livros:</h4>

		<form action="/livro" method="get">
			<button type="submit">Novo livro</button>
		</form>
		
 		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">
				<strong>Confirmação!</strong> ${mensagem}
			</div>
		</c:if>

		

		<c:if test="${not empty livroLista}">
			<p>Quantidade de livros cadastrados: ${livroLista.size()}</p>
			<table class="table table-dark table-striped">
				<thead>
					<tr>
						<th>Id</th>
						<th>Título</th>
						<th>Autor</th>
						<th>Qtd. de Páginas</th>
						<th>Valor</th>
						<th>Gênero</th>
						<th>Class. Etária</th>
						<th>Ilustrado</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="l" items="${livroLista}">

						<tr>
							<td>${l.id}</td>
							<td>${l.titulo}</td>
							<td>${l.autor}</td>
							<td>${l.qtdePaginas}</td>
							<td>${l.valor}</td>
							<td>${l.genero}</td>
							<td>${l.classificacaoEtaria}</td>
							<td>${l.ilustrado}</td>
							<th><a href="/livro/${l.id}/excluir">Excluir</a></th>
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
						<th>Gênero</th>
						<th>Class. Etária</th>
						<th>Ilustrado</th>
						<th></th>
					</tr>
				</tfoot>
			</table>

		</c:if>

		<c:if test="${empty livroLista}">
			<p>Não existem livros cadastrados!!!</p>
		</c:if>

	</div>
</body>
</html>
