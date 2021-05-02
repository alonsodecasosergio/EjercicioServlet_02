<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, servlet.*" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Alta Productos</title>
	</head>
	<body>
		<%@ include file="Cabecera.jsp" %>
		
		<form id="altaProductos" action="AltaProductos" method="post">
	    <input type="number" name="id" placeholder="ID Categoria" required> </br>
	    <input type="text" placeholder="Nombre" name="nombre" required> </br>
	    <input type="text" placeholder="Descripcion" name="descripcion" required> </br>
	    <input type="text" placeholder="Precio" name="precio" required> </br> 
	    <input type="text" placeholder="Stock" name="stock" required> </br>
	    <input type="text" placeholder="Fecha Alta" name="fechaAlta" required> </br>
	    <input type="text" placeholder="Fecha Baja" name="fechaBaja" required> </br>
	    <input type="text" placeholder="Impuesto" name="impuesto" required> </br>
	    
	    <button type="submit" title="Registrar" name="Registrar">Añadir producto</button>
    </form>
	</body>
</html>