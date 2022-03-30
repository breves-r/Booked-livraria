<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Booked</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/custom.css" rel="stylesheet" />
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body id="page-top">
        <!-- Navigation-->
        <c:import url="/WEB-INF/jsp/menu.jsp"/>
        <!-- Masthead-->
        <header class="masthead">
            <div class="container">
            
                <div class="masthead-heading text-uppercase">Bem vindo!</div>
                <div class="masthead-subheading">Projeto final da disciplina de Desenvolvimento Web com Java</div>
                <a class="btn btn-primary btn-xl text-uppercase" href="https://github.com/breves-r/Booked-livraria" target="_blank">Github do Projeto</a>
            </div>
        </header>
        <!-- Services-->
        <section class="page-section" id="services">
            <div class="container">
                <div class="text-center">
                    <h2 class="section-heading text-uppercase">Serviços</h2>
                    <h3 class="section-subheading text-muted">Quantidade de itens cadastrados.</h3>
                </div>
                <div class="row text-center">
                
                    <c:forEach var="m" items="${mapa}">
                    <div class="col-md-4">
                        <span class="fa-stack fa-4x">
                            <i class="fas fa-circle fa-stack-2x text-primary"></i>
                            <i class="fas fa-laptop fa-stack-1x fa-inverse"></i>
                        </span>
                        <h4 class="my-3">${m.key}</h4>
                        <p class="text-muted">${m.value}</p>
                    </div>
                    </c:forEach>
                    
                </div>
            </div>
        </section>
        
  
        <!-- Footer-->
        <footer class="footer py-4">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-4 text-lg-start">Rafaela Curty Breves &copy; Instituto Infnet 2022</div>
                    <div class="col-lg-4 my-3 my-lg-0">
                        <a class="btn btn-dark btn-social mx-2" href="https://www.linkedin.com/in/curtyrafaela/" target="_blank"><i class="fab fa-linkedin-in"></i></a>
                    </div>
                    <div class="col-lg-4 text-lg-end">
                        <a class="link-dark text-decoration-none" href="#!">Professor Elberth Moraes</a>
                    </div>
                </div>
            </div>
        </footer>
        
       
       
     
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <!-- * *                               SB Forms JS                               * *-->
        <!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
    </body>
</html>
