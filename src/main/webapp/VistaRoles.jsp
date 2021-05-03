<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, servlet.*, dataModelDAO.*, dataModelEntities.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Vista Roles</title>
	</head>
	<body>		
		<%@ include file="Cabecera.jsp" %>	
		
		<form action="" method="post">
			<table class="table table-striped" border="2">
				<thead class="table-dark">
					<tr>
				  	  	<th>Id</th>
				    	<th>Nombre</th>
			   		 </tr>
	  			</thead>
				
			    <c:forEach items="${sessionScope.rolesList}" var="rol" varStatus="status" begin="0" end="${sessionScope.rolesList.size() - 1}">
			        <tr>
			        
			        	<td><c:out value="${rol.id}"></c:out></td>
			            <td><c:out value="${rol.rol}"></c:out></td>           
			        </tr>
			    </c:forEach>
			</table>
		</form>
		
	</body>
</html>