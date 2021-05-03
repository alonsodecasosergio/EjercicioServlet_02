<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, servlet.*, dataModelDAO.*, dataModelEntities.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Vista Categorias</title>
	</head>
	<body>		
		<%@ include file="Cabecera.jsp" %>	
		
		<form action="" method="post">
			<table class="table" border="2">
				<tr>
				    <th>Id</th>
				    <th>Nombre</th>
				    <th>Descripcion</th>
			    </tr>
			    <c:forEach items="${sessionScope.categoriasList}" var="categoria" varStatus="status" begin="0" end="${sessionScope.categoriasList.size() - 1}">
			        <tr>
			        
			        	<td><c:out value="${categoria.id}"></c:out></td>
			            <td><c:out value="${categoria.nombre}"></c:out></td>           
			            <td><c:out value="${categoria.descripcion}"></c:out></td>   
			        </tr>
			    </c:forEach>
			</table>
		</form>
		
	</body>
</html>