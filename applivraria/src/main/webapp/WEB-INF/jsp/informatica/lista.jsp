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
	
		<h4>Cadastramento de livros de informática:</h4>

		<form action="/informatica" method="get">
			<button type="submit">Novo livro de informática</button>
		</form>
		
 		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">
				<strong>Confirmação!</strong> ${mensagem}
			</div>
		</c:if>

		

		<c:if test="${not empty informaticaLista}">
			<p>Quantidade de livros de informática cadastrados: ${informaticaLista.size()}</p>
			<table class="table table-dark table-striped">
				<thead>
					<tr>
						<th>Id</th>
						<th>Título</th>
						<th>Autor</th>
						<th>Qtd. de Páginas</th>
						<th>Valor</th>
						<th>Área</th>
						<th>Programação</th>
						<th>Avançado</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="i" items="${informaticaLista}">

						<tr>
							<td>${i.id}</td>
							<td>${i.titulo}</td>
							<td>${i.autor}</td>
							<td>${i.qtdePaginas}</td>
							<td>${i.valor}</td>
							<td>${i.area}</td>
							<td>${i.ehProgramacao}</td>
							<td>${i.ehAvancado}</td>
							<th><a href="/informatica/${i.id}/excluir">Excluir</a></th>
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
						<th>Área</th>
						<th>Programação</th>
						<th>Avançado</th>
						<th></th>
					</tr>
				</tfoot>
			</table>

		</c:if>

		<c:if test="${empty informaticaLista}">
			<p>Não existem livros de informática cadastrados!!!</p>
		</c:if>

	</div>
</body>
</html>
