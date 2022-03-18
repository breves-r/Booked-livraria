<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
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
	
		<h4>Cadastramento de Produtos:</h4>

		
 		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">
				<strong>Confirmação!</strong> ${mensagem}
			</div>
		</c:if>

		

		<c:if test="${not empty produtoLista}">
			<p>Quantidade de produtos cadastrados: ${produtoLista.size()}</p>
			<table class="table table-dark table-striped">
				<thead>
					<tr>
						<th>Id</th>
						<th>Título</th>
						<th>Autor</th>
						<th>Qtd. de Páginas</th>
						<th>Valor</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="p" items="${produtoLista}">

						<tr>
							<td>${p.id}</td>
							<td>${p.titulo}</td>
							<td>${p.autor}</td>
							<td>${p.qtdePaginas}</td>
							<td>${p.valor}</td>
							<th><a href="/produto/${p.id}/excluir">Excluir</a></th>
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
						<th></th>
					</tr>
				</tfoot>
			</table>

		</c:if>

		<c:if test="${empty produtoLista}">
			<p>Não existem produtos cadastrados!!!</p>
		</c:if>

	</div>
</body>
</html>
