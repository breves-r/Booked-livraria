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

		<form action="/livro/incluir" method="post">
			<h2>Cadastramento de Livros</h2>
			
			<div class="row align-items-stretch mb-5">
			<div class="col-md-6">
			
			<div class="form-group">
				<label>Título:</label> <input type="text" class="form-control"
					name="titulo" value="Orlando">
			</div>

			<div class="form-group">
				<label>Autor:</label> <input type="text" class="form-control"
					name="autor" value="V.W.">
			</div>

			<div class="form-group">
				<label>Qtd. de Páginas:</label> <input type="text" class="form-control"
					name="qtdePaginas" value="300">
			</div>

			<div class="form-group">
				<label>Valor:</label> <input type="text" class="form-control"
					name="valor" value="65">
			</div>

</div>
<div class="col-md-6">
			<div class="container">
			<div class="form-group">
			<br>
				<label>Gênero:</label> <input type="text" class="form-control"
					name="genero" value="Romance">
			<br>
			</div>
			</div>
			
			<div class="container">
			<div class="form-group">
			<br>
				<label>Classificação:</label> <input type="text" class="form-control"
					name="classificacaoEtaria" value="16">
			<br>
			</div>
			</div>

			<div class="container">
			<div class="form-group">
			<br>
				<label>Característica:</label>

				<div class="form-check form-check-inline">
					<label><input type="checkbox" name="ilustrado"
						value="true" checked> Ilustrado</label>
				</div>
				<br>
			</div>
			</div>

			
</div>
</div>
			<button type="submit">Cadastrar</button>
		</form>

	</div>
	</header>
</body>
</html>