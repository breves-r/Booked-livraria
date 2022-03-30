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

		<form action="/cliente/incluir" method="post">
			<div class="masthead-subheading">Cadastramento de clientes:</div>
			
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


</div>
<div class="col-md-6">

			<div class="form-group">
				<label>Telefone:</label> <input type="text" class="form-control"
					name="telefone" value="2190909090">
			</div>

			<div class="form-group">
				<label>CPF:</label> <input type="text" class="form-control"
					name="cpf" value="987654321-10">
			</div>
</div>
</div>
			<button type="submit">Cadastrar</button>
		</form>

	</div>
	</header>
</body>
</html>