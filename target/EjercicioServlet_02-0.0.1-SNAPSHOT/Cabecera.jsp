<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, servlet.*" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Cabecera</title>
		
		<link rel="stylesheet" href="styleCabecera.css">
		
		<style type="text/css">
            
        </style>
	</head>
	<body>
		<header id="main-header">
		
			<a id="logo-header">
				<span class="site-name">${sessionScope.clientName}.</span>
			</a> <!-- / #logo-header -->
	
			<form id="botonesCabecera" action="" method="post">
					
				<button type="submit" formaction="PanelPrincipal.jsp">Volver</button>
				<button type="submit" formaction="CerrarSesion">Cerrar Sesion</button>
			</form>

		</header>
	</body>
</html>