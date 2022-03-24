<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	
		<div class="masthead-subheading">Cadastramento de clientes:</div>

 		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">
				<strong>Confirmação!</strong> ${mensagem}
			</div>
		</c:if>

		<form action="/cliente" method="get">
			<button type="submit" class="btn btn-primary">Novo cliente</button>
		</form>

		<c:if test="${not empty clienteLista}">
			<p>Quantidade de clientes cadastrados: ${clienteLista.size()}</p>
			<table class="table table-dark table-striped">
				<thead>
					<tr>
						<th>Nome</th>
						<th>E-mail</th>
						<th>Telefone</th>
						<th>CPF</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="c" items="${clienteLista}">

						<tr>
							<td>${c.nome}</td>
							<td>${c.email}</td>
							<td>${c.telefone}</td>
							<td>${c.cpf}</td>
							<th><a href="/cliente/${c.id}/excluir">Excluir</a></th>
						</tr>
					</c:forEach>

				</tbody>
				<tfoot>
					<tr>
						<th>Nome</th>
						<th>E-mail</th>
						<th>Telefone</th>
						<th>CPF</th>
						<th></th>
					</tr>
				</tfoot>
			</table>

		</c:if>

		<c:if test="${empty clienteLista}">
			<p>Não existem clientes cadastrados!!!</p>
		</c:if>

	</div>
</header>
</body>
</html>
