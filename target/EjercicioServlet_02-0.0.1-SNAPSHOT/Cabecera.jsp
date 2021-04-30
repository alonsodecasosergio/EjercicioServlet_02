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
		<div id="cabecera">
			<h3>Bienvenido JSP, ${sessionScope.clientName}.</h3>
			<form action="" method="post">
				<button type="submit" formaction="">Cerrar Sesion</button>
				<button type="submit" formaction="PanelPrincipal.jsp">Volver</button>
			</form>
		</div>
	</body>
</html>