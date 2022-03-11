<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<title>Booked</title>
</head>
<body>
	<div class="container">
	  <h2>Sistema de Cadastramento de Alunos</h2>

		<c:if test="${not empty mensagem}">
			<div class="alert alert-warning">
			  <strong>Atenção!</strong> ${mensagem}
			</div>
		</c:if>

	  <form action="/login" method="post">
	    <div class="form-group">
	      <label>E-mail:</label>
	      <input type="email" class="form-control" placeholder="Entre com o seu e-mail" name="email" value="rafaela.curty@infnet.com">
	    </div>
	    
	    <div class="form-group">
	      <label>Senha:</label>
	      <input type="password" class="form-control" placeholder="Entre com a sua senha" name="senha" value="123">
	    </div>
	    
	    <button type="submit" class="btn btn-default">Entrar</button>
	  </form>
	</div>
</body>
</html> 