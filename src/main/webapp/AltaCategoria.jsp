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
		
		<form id="altaCategoria" action="" method="post">
			<input type="text" name="nombre" placeholder="Nombre" required>
			<input type="text" name="descripcion" placeholder="Descripcion" required>
			<button type="submit" title="Registrar" name="Registrar">Registrar Categoria</button>
		</form>
    </form>
	</body>
</html>