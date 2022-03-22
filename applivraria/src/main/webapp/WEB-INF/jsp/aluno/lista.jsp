<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="edu.infnet.applivraria.model.domain.Aluno"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="ISO-8859-1">
		<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
		<title>Booked</title>
</head>

<body>
	<c:import url="/WEB-INF/jsp/menu.jsp" />
	
	<header class="masthead">

	<div class="container">
	
		<div class="masthead-subheading">Cadastramento de alunos:</div>

 		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">
				<strong>Confirmação!</strong> ${mensagem}
			</div>
		</c:if>

		<form action="/aluno" method="get">
			<button type="submit">Novo aluno</button>
		</form>

		<c:if test="${not empty alunoLista}">
			<p>Quantidade de alunos cadastrados: ${alunoLista.size()}</p>
			<table class="table table-dark table-striped">
				<thead>
					<tr>
						<th>Nome</th>
						<th>E-mail</th>
						<th>Idade</th>
						<th>Curso</th>
						<th>Região</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="a" items="${alunoLista}">

						<tr>
							<td>${a.nome}</td>
							<td>${a.email}</td>
							<td>${a.idade}</td>
							<td>${a.curso}</td>
							<td>${a.regiao}</td>
							<th><a href="/aluno/${a.id}/excluir">Excluir</a></th>
						</tr>
					</c:forEach>

				</tbody>
				<tfoot>
					<tr>
						<th>Nome</th>
						<th>E-mail</th>
						<th>Idade</th>
						<th>Curso</th>
						<th>Região</th>
						<th></th>
					</tr>
				</tfoot>
			</table>

		</c:if>

		<c:if test="${empty alunoLista}">
			<p>Não existem alunos cadastrados!!!</p>
		</c:if>

	</div>
</header>
</body>
</html>
