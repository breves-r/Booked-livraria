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

	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	
	<header class="masthead">
	
	<div class="container">

		<form action="/usuario/incluir" method="post">
			<!-- <h2>Cadastramento de Usuários</h2> -->
			 <div class="masthead-subheading">Cadastramento de Usuários</div>

			<div class="container">

			<div class="form-group row">
				<label for="inputNome" class="col-sm-2 col-form-label">Nome:</label> 
				<div class="col-sm-10">
				<input type="text" class="form-control"
					name="nome" id ="inputNome" value="Elberth L C Moraes">
					</div>
			</div>

			<div class="form-group row">
				<label for="inputEmail" class="col-sm-2 col-form-label">E-mail:</label> 
				<div class="col-sm-10">
				<input type="email" class="form-control"
					name="email" id="inputEmail" value="elberth.moraes@prof.infnet.edu.br">
				</div>
				
			</div>

			
			<div class="form-group row">
				<label for="inputSenha" class="col-sm-2 col-form-label">Senha:</label> 
				<div class="col-sm-10">
				<input type="password" class="form-control"
					name="senha" id="inputSenha" value="123">
			</div>
			</div>
			
			</div>

			

			<button type="submit">Cadastrar</button>
		</form>

	</div>
	</header>

</body>
</html>