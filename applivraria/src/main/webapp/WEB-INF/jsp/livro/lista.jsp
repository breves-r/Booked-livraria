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
	
		<div class="masthead-subheading">Cadastramento de livros:</div>

		<form action="/livro" method="get">
			<button type="submit" class="btn btn-primary">Novo livro</button>
		</form>
		
 		<c:if test="${not empty mensagem}">
			<div class="alert alert-warning">
				${mensagem}
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
</header>
</body>
</html>
