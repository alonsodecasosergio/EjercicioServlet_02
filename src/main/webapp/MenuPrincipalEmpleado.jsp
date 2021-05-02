<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, servlet.*" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Panel Principal</title>
	</head>
	<body>
		<%@ include file="Cabecera.jsp" %>
		
		</br>
		<form action="" method="post">
			<button type="submit" formaction="VistaUsuarios">Listado de usuarios</button>
			<button type="submit" formaction="VistaRoles">Listado de roles</button>
			<button type="submit" formaction="VistaCategorias">Listado de categorias</button>
			<button type="submit" formaction="AltaCategoria.jsp">Alta categoria</button>
		</form>
	</body>
</html>