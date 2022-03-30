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
	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	
	<header class="masthead">

	<div class="container">
	  <div class="masthead-subheading">Sistema de Cadastramento de Alunos</div>

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
	    
	    <button type="submit">Entrar</button>
	  </form>
	</div>
	</header>
</body>
</html> 