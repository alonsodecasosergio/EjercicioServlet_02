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
		
		<form action="" method="post">
			<button type="submit"  class="btn btn-outline-primary" formaction="VistaUsuarios">Listado de usuarios</button>
			<button type="submit"  class="btn btn-outline-primary" formaction="VistaRoles">Listado de roles</button>
			<button type="submit"  class="btn btn-outline-primary" formaction="VistaCategorias">Listado de categorias</button>
			<button type="submit"  class="btn btn-outline-primary" formaction="VistaProductos">Listado de productos</button>
			<button type="submit"  class="btn btn-outline-primary" formaction="AltaCategoria.jsp">Alta categoria</button>
			<button type="submit"  class="btn btn-outline-primary" formaction="AltaProductos.jsp">Alta producto</button>
		</form>
	</body>
</html>