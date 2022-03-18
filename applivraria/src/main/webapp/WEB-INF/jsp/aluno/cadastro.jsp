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

		<form action="/aluno/incluir" method="post">
			<h2>Cadastramento de Alunos</h2>
			
			<div class="row align-items-stretch mb-5">
			<div class="col-md-6">
			
			<div class="form-group">
				<label>Nome:</label> <input type="text" class="form-control"
					name="nome" value="Elberth L C Moraes">
			</div>

			<div class="form-group">
				<label>E-mail:</label> <input type="email" class="form-control"
					name="email" value="elberth.moraes@prof.infnet.edu.br">
			</div>

			<div class="form-group">
				<label>Idade:</label> <input type="text" class="form-control"
					name="idade" value="43">
			</div>

			<div class="form-group">
				<label>Mensalidade:</label> <input type="text" class="form-control"
					name="mensalidade" value="1000">
			</div>

</div>
<div class="col-md-6">
			<div class="container">
			<div class="form-group">
			<br>
				<label>Curso:</label>

				<div class="form-check form-check-inline">
					<label><input type="radio" name="curso" value="G">
						Graduação</label>
				</div>
				<div class="form-check form-check-inline">
					<label><input type="radio" name="curso" value="E">
						Especialização</label>
				</div>
				<div class="form-check form-check-inline">
					<label><input type="radio" name="curso" value="M" checked>
						Mestrado</label>
				</div>
				<div class="form-check form-check-inline">
					<label><input type="radio" name="curso" value="D">
						Doutorado</label>
				</div>
				<br>
			</div>
			</div>

			<div class="container">
			<div class="form-group">
			<br>
				<label>Disciplinas:</label>

				<div class="form-check form-check-inline">
					<label><input type="checkbox" name="disciplinas"
						value="fun" checked> Fundamentos Java</label>
				</div>
				<div class="form-check form-check-inline">
					<label><input type="checkbox" name="disciplinas"
						value="poo" checked> Orientação a Objetos</label>
				</div>
				<div class="form-check form-check-inline">
					<label><input type="checkbox" name="disciplinas"
						value="web" checked> Java Web</label>
				</div>
				<br>
			</div>
			</div>

			<div class="container">
			<div class="form-group">
			<br>
				<label>Região:</label> <select name="regiao" class="form-control">
					<option value="S">Sul</option>
					<option value="Su" selected>Sudeste</option>
					<option value="C">Centro-Oeste</option>
					<option value="N">Norte</option>
					<option value="No">Nordeste</option>
				</select>
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