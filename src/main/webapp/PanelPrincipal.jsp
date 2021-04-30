<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, servlet.*" %>
>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Panel Principal</title>
	</head>
	<body>
		<h3>Bienvenido JSP, ${sessionScope.clientName}.</h3>
		<form action="" method="post">
			<button type="submit" formaction="AltaUsuarios.jsp">Alta Usuario</button>
			<button type="submit" formaction="AltaRoles.jsp">Alta Roles</button>
			<button type="submit" formaction="VistaUsuarios">Listado de usuarios</button>
			<button type="submit" formaction="">Listado de roles</button>
		</form>
	</body>
</html>