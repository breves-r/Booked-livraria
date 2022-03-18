<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
	<div class="container">
		<a class="navbar-brand" href="/">Booked</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			Menu <i class="fas fa-bars ms-1"></i>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav text-uppercase ms-auto py-4 py-lg-0">
				<c:if test="${not empty user}">
					<li class="nav-item"><a class="nav-link" href="/usuarios">Usuário</a></li>
					<li class="nav-item"><a class="nav-link" href="/alunos">Aluno</a></li>
					<li class="nav-item"><a class="nav-link" href="/produtos">Produtos</a></li>
					<li class="nav-item"><a class="nav-link" href="/livros">Livro</a></li>
					<li class="nav-item"><a class="nav-link" href="/escolares">Escolar</a></li>
					<li class="nav-item"><a class="nav-link" href="/informaticos">Informática</a></li>
				</c:if>
			<!-- 	<li class="nav-item"><a class="nav-link" href="#services">Services</a></li>
				<li class="nav-item"><a class="nav-link" href="#portfolio">Portfolio</a></li>
				<li class="nav-item"><a class="nav-link" href="#about">About</a></li>
				<li class="nav-item"><a class="nav-link" href="#team">Team</a></li>
				<li class="nav-item"><a class="nav-link" href="#contact">Contact</a></li> -->

				<c:if test="${empty user}">
					<li class="nav-item"><a class="nav-link" href="/login">Login</a></li>
					<li class="nav-item"><a class="nav-link" href="/usuario">Sign
							Up</a></li>
				</c:if>

				<c:if test="${not empty user}">
					<li class="nav-item"><a class="nav-link" href="/logout">Logout,
							${user.nome}</a></li>
				</c:if>

			</ul>
		</div>
	</div>
</nav>