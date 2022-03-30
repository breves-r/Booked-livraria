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

	<div class="container" >	

		<div class="masthead-subheading">Cadastramento de Usuários</div>

		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">
			  <strong>Confirmação!</strong> ${mensagem}
			</div>
		</c:if>

		<c:if test="${not empty usuarioLista}">
		  	<p>Quantidade de usuários cadastrados: ${usuarioLista.size()}</p>            
		  	<table class="table table-dark table-striped">
			    <thead>
			      <tr>
			        <th>Nome</th>
			        <th>E-mail</th>
			        <th>Endereço</th>
			        <th>Admin</th>
			        <th>Clientes</th>
			        <th>Produtos</th>
			        <th>Compras</th>
			        <th></th>
			      </tr>
			    </thead>
			    <tbody>
			    <c:forEach var="u" items="${usuarioLista}">
			      <tr>
			        <td>${u.nome}</td>
			        <td>${u.email}</td>
			        <td>${u.endereco.uf}</td>
			        <td>${u.admin}</td>
			        <td>${u.clientes.size()}</td>
			        <td>${u.produtos.size()}</td>
			        <td>${u.compras.size()}</td>
			        <td>
			        <c:if test="${user.admin}">
			        	<c:if test="${user.id != u.id}">
			        	<a href="/usuario/${u.id}/excluir">Excluir</a>
			        	</c:if>
			        </c:if>
			        </td>
			      </tr>
				</c:forEach>
			    </tbody>
			    <tfoot>
			      <tr>
			        <th>Nome</th>
			        <th>E-mail</th>
			        <th>Endereço</th>
			        <th>Admin</th>
			        <th>Clientes</th>
			        <th>Produtos</th>
			        <th>Compras</th>
			        <th></th>
			      </tr>
			    </tfoot>
		  	</table>
		</c:if>
		
		<c:if test="${empty usuarioLista}">
	  		<p>Não existem usuários cadastrados!!!</p>            
	  	</c:if>
	</div>
	</header>
</body>
</html>