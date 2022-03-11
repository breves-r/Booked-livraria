<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>Booked</title>
</head>
<body>
	<div class="container">

		<form action="/usuario/incluir" method="post">
			<h2>Cadastramento de Usuários</h2>

			<div class="form-group">
				<label>Nome:</label> <input type="text" class="form-control"
					name="nome" value="Elberth L C Moraes">
			</div>

			<div class="form-group">
				<label>E-mail:</label> <input type="email" class="form-control"
					name="email" value="elberth.moraes@prof.infnet.edu.br">
			</div>

			<div class="form-group">
				<label>Senha:</label> <input type="password" class="form-control"
					name="senha" value="123">
			</div>

			

			<button type="submit">Cadastrar</button>
		</form>

	</div>

</body>
</html>