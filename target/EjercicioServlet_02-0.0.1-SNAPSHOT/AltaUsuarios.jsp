<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, servlet.*" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Alta Usuarios</title>
	</head>
	<body>
		<%@ include file="Cabecera.jsp" %>
		
		<form id="altaUsuarios" action="AltaUsuarios" method="post">
	    <input type="number" name="rol" placeholder="ID Rol" required> </br>
	    <input type="text" placeholder="Email" name="email" required> </br>
	    <input type="password" placeholder="Clave" name="clave" required> </br>
	    <input type="text" placeholder="Nombre" name="nombre" required> </br>
	    <input type="text" placeholder="Primer Apellido" name="apellido1" required> </br> 
	    <input type="text" placeholder="Segundo Apellido" name="apellido2" required> </br>
	    <input type="text" placeholder="Direccion" name="direccion" required> </br>
	    <input type="text" placeholder="Localidad" name="localidad" required> </br>
	    <input type="text" placeholder="Provincia" name="provincia" required> </br>
	    <input type="text" placeholder="Telefono" name="telefono" required> </br>
	    <input type="text" placeholder="DNI" name="dni" required> </br>
	    
	    <button type="submit" title="Registrar" name="Registrar">Registrar</button>
    </form>
	</body>
</html>