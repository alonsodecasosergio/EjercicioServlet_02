<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, servlet.*" %>

<!DOCTYPE html>
<html>
	 <head>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <meta name="description" content="">
	    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
	    <meta name="generator" content="Hugo 0.82.0">
	    <title>Encabezado</title>
	
	    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/headers/">

    

    <!-- Bootstrap core CSS -->
	<link href="css/bootstrap.min.css" rel="stylesheet">
	
	    <style>
	      .bd-placeholder-img {
	        font-size: 1.125rem;
	        text-anchor: middle;
	        -webkit-user-select: none;
	        -moz-user-select: none;
	        user-select: none;
	      }
	
	      @media (min-width: 768px) {
	        .bd-placeholder-img-lg {
	          font-size: 3.5rem;
	        }
	      }
	    </style>

    
    <!-- Custom styles for this template -->
    <link href="css/headers.css" rel="stylesheet">
  </head>
	<body>
	<div class="container">
	  <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
	    <a href="/" class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none">
	      <svg class="bi me-2" width="40" height="20"><use xlink:href="#bootstrap"/></svg>
	    </a>
	    <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
    		<li><a class="nav-link px-2 link-secondary">${sessionScope.clientRol} | ${sessionScope.clientName}</a></li>
  	  	</ul>
	
	    <div class="col-md-3 text-end">
	    	<form action="" method="post">
	      		<button type="submit" formaction=${sessionScope.Menu} class="btn btn-outline-primary me-2">Volver</button>
	      		<button type="submit" formaction="CerrarSesion" class="btn btn-primary">Cerrar sesion</button>
	    	</form>
	    </div>
	  </header>
	</div>
	</body>
</html>