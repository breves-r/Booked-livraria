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

		<form action="/escolar/incluir" method="post">
			<div class="masthead-subheading">Cadastramento de Livros Escolares</div>
			
			<div class="row align-items-stretch mb-5">
			<div class="col-md-6">
			
			<div class="form-group">
				<label>Título:</label> <input type="text" class="form-control"
					name="titulo" value="História do Brasil">
			</div>

			<div class="form-group">
				<label>Autor:</label> <input type="text" class="form-control"
					name="autor" value="C.B.">
			</div>

			<div class="form-group">
				<label>Qtd. de Páginas:</label> <input type="text" class="form-control"
					name="qtdePaginas" value="500">
			</div>

			<div class="form-group">
				<label>Valor:</label> <input type="text" class="form-control"
					name="valor" value="300">
			</div>

</div>
<div class="col-md-6">
			<div class="container">
			<div class="form-group">
			<br>
				<label>Disciplina:</label> <input type="text" class="form-control"
					name="disciplina" value="História">
			<br>
			</div>
			</div>
			
			<div class="container">
			<div class="form-group">
			<br>
				<label>Série:</label> <input type="text" class="form-control"
					name="serie" value="8">
			<br>
			</div>
			</div>

			<div class="container">
			<div class="form-group">
			<br>
				<label>Característica:</label>

				<div class="form-check form-check-inline">
					<label><input type="checkbox" name="temRespostas"
						value="true" checked> Tem Respostas</label>
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