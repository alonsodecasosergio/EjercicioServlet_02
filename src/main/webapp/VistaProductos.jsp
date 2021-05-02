<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, servlet.*, dataModelDAO.*, dataModelEntities.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Vista Productos</title>
	</head>
	<body>			
		<%@ include file="Cabecera.jsp" %>
		
		<form action="" method="post">
			<table border="2">
				<tr>
				    <th>Id</th>
				    <th>Id Categoria</th>
				    <th>Nombre</th>
				    <th>Descripcion</th>
				    <th>Precio</th>
				    <th>Stock</th>
				    <th>Fecha Alta</th>
				    <th>Fecha Baja</th>
				    <th>Impuesto</th>
			    </tr>
			    <c:forEach items="${sessionScope.productosList}" var="producto" varStatus="status" begin="0" end="${sessionScope.productosList.size() - 1}">
			        <tr>
			        
			        	<td><c:out value="${producto.id}"></c:out></td>
			            <td><c:out value="${producto.idCategoria}"></c:out></td>
			            <td><c:out value="${producto.nombre}"></c:out></td>
			            <td><c:out value="${producto.descripcion}"></c:out></td>
			            <td><c:out value="${producto.precio}"></c:out></td>
			            <td><c:out value="${producto.stock}"></c:out></td>
			            <td><c:out value="${producto.fechaAlta}"></c:out></td>
			            <td><c:out value="${producto.fechaBaja}"></c:out></td>
			            <td><c:out value="${producto.impuesto}"></c:out></td>          
			        </tr>
			    </c:forEach>
			</table>
		</form>
		
	</body>
</html>