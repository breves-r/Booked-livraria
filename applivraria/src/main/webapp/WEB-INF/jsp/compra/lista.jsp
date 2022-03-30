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
        <link href="css/custom.css" rel="stylesheet" />
        <link href="css/styles.css" rel="stylesheet" />
		<title>Booked</title>
</head>

<body>
	<c:import url="/WEB-INF/jsp/menu.jsp" />
	
	<header class="masthead">

	<div class="container">
	
		<div class="masthead-subheading">Cadastramento de compras:</div>


		<form action="/compra" method="get">
			<button type="submit" class="btn btn-primary">Nova compra</button>
		</form>

		<c:if test="${not empty compraLista}">
			<p>Quantidade de compras cadastradas: ${compraLista.size()}</p>
			<table class="table table-dark table-striped">
				<thead>
					<tr>
						<th>Data</th>
						<th>Forma de Pagamento</th>
						<th>Cliente</th>
						<th>Produtos</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="c" items="${compraLista}">

						<tr>
							<td>${c.data}</td>
							<td>${c.formaPagamento}</td>
							<td>${c.cliente.nome}</td>
							<td>${c.listaProdutos.size()}</td>
							<th><a href="/compra/${c.id}/excluir">Excluir</a></th>
						</tr>
					</c:forEach>

				</tbody>
				<tfoot>
					<tr>
						<th>Data</th>
						<th>Forma de Pagamento</th>
						<th>Cliente</th>
						<th>Produtos</th>
						<th></th>
					</tr>
				</tfoot>
			</table>

		</c:if>

		<c:if test="${empty compraLista}">
			<p>Não existem compras cadastradas!!!</p>
		</c:if>

	</div>
</header>
</body>
</html>
