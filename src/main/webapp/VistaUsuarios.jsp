<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, servlet.*, dataModelDAO.*, dataModelEntities.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Alta Usuarios</title>
	</head>
	<body>			
		<%@ include file="Cabecera.jsp" %>
		
		<form action="" method="post">
			<table class="table table-striped" border="2">
			<thead class="table-dark">
				<th>Id</th>
				    <th>Rol</th>
				    <th>Email</th>
				    <th>Clave</th>
				    <th>Nombre</th>
				    <th>Primer Apellido</th>
				    <th>Segundo Apellido</th>
				    <th>Direccion</th>
				    <th>Localidad</th>
				    <th>Provincia</th>
				    <th>Telefono</th>
				    <th>DNI</th>
  			</thead>
			    <c:forEach items="${sessionScope.usuariosList}" var="usuario" varStatus="status" begin="0" end="${sessionScope.usuariosList.size() - 1}">
			        <tr>
			        
			        	<td><c:out value="${usuario.id}"></c:out></td>
			            <td><c:out value="${usuario.rol}"></c:out></td>
			            <td><c:out value="${usuario.email}"></c:out></td>
			            <td><c:out value="${usuario.clave}"></c:out></td>
			            <td><c:out value="${usuario.nombre}"></c:out></td>
			            <td><c:out value="${usuario.apellido1}"></c:out></td>
			            <td><c:out value="${usuario.apellido2}"></c:out></td>
			            <td><c:out value="${usuario.direccion}"></c:out></td>
			            <td><c:out value="${usuario.localidad}"></c:out></td>		
			            <td><c:out value="${usuario.provincia}"></c:out></td>
			            <td><c:out value="${usuario.telefono}"></c:out></td>
			            <td><c:out value="${usuario.dni}"></c:out></td>            
			        </tr>
			    </c:forEach>
			</table>
		</form>
		
	</body>
</html>