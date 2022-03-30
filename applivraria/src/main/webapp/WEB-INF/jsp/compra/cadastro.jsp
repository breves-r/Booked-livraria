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

	<c:set var="botao" value=""/>
	
	<c:import url="/WEB-INF/jsp/menu.jsp" />
	
	<header class="masthead">
	<div class="container">

		<form action="/compra/incluir" method="post">
			<div class="masthead-subheading">Cadastramento de compra:</div>
			
			<div class="row align-items-stretch mb-5">
			<div class="col-md-6">
			
			<div class="form-group">
				<label>Forma de Pagamento:</label> <input type="text" class="form-control"
					name="formaPagamento" value="Cartão">
			</div>
			
			<div class="form-group">
				<c:if test="${not empty clienteLista}">
					<label>Cliente:</label>
					<select name="cliente.id" class="form-control">
						<c:forEach var="c" items="${clienteLista}">
							<option value="${c.id}">${c.nome}</option>
						</c:forEach>
					</select>
				</c:if>
				
				<c:if test="${empty clienteLista}">
					<label>Não existem clientes cadastrados!</label>
					<c:set var="botao" value="disabled"/>
				</c:if>
			</div>


</div>
<div class="col-md-6">

			<div class="form-group">
				<c:if test="${not empty produtoLista}">
				<label>Produtos:</label>

				<c:forEach var="p" items="${produtoLista}">
					<div class="checkbox">
					  <label><input type="checkbox" name="idsProdutos" value="${p.id}" checked> ${p.titulo}</label>
					</div>
				</c:forEach>	
				
				</c:if>
				
				<c:if test="${empty produtoLista}">
					<label>Não existem produtos cadastrados!</label>
					<c:set var="botao" value="disabled"/>
				</c:if>
			</div>
			
			
</div>
</div>
			<button ${botao} type="submit">Cadastrar</button>
		</form>

	</div>
	</header>
</body>
</html>