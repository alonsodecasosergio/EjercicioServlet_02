<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, servlet.*, dataModelEntities.*, service.*" %>

<!DOCTYPE html>
<html>
	 <head>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <meta name="description" content="">
	    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
	    <meta name="generator" content="Hugo 0.82.0">
	    <title>Tienda Online | Sergio Alonso</title>
	
	    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/headers/">

    

    <!-- Bootstrap core CSS -->
	<link href="css/bootstrap.min.css" rel="stylesheet">
	
	    <style>
	      .bd-placeholder-img {
	        font-size: 1.125rem;
	        text-anchor: middle;
	        -webkit-user-select: none;
	        -moz-user-select: none;
	        user-select: none;
	      }
	
	      @media (min-width: 768px) {
	        .bd-placeholder-img-lg {
	          font-size: 3.5rem;
	        }
	      }
	    </style>

    
    <!-- Custom styles for this template -->
    <link href="css/headers.css" rel="stylesheet">
  </head>
	<body>
		<%@ include file="Header.jsp" %>		
		<div class="container" style="margin-top:5%">
		 	<div class="row">
		 	<%
		 			ArrayList<Productos> productos = ProductosService.getAllProductos();
	    			for(Productos producto : productos){
	    				
	    			
		 	%>
		        <div class="col-lg-3 col-md-6 mb-4">
		            <div class="card h-100">
		                <a href="#!"><img class="card-img-top" src="https://via.placeholder.com/700x400" alt="..." /></a>
		                <div class="card-body">
		                    <h4 class="card-title"><a href="#!"><%=producto.getNombre() %></a></h4>
		                    <h5><%=producto.getPrecio() %> €</h5>
		                    <p class="card-text"><%=producto.getDescripcion() %></p>
		                </div>
		                <div class="card-footer"><small class="text-muted"> Stock: <%=producto.getStock() %></small></div>
		            </div>
		        </div>
		        <%
	    			}
		        %>
			</div>
		</div>
	</body>
</html>