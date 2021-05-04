<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, servlet.*" %>

<!DOCTYPE html>
<html>
	 <head>
	    <meta charset="utf-8">
	    <title>Encabezado</title>
	

    

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
    <link href="css/header.css" rel="stylesheet">
  </head>
	<body>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/2.1.3/TweenMax.min.js"></script>
		<div class="super_container">
		    <!-- Header -->
		    <header class="header">
		        <!-- Top Bar -->
		        <div class="top_bar">
		            <div class="container">
		                <div class="row">
		                    <div class="col d-flex flex-row-reverse">
		                            <div class="top_bar_user">
		                                <div class="user_icon"><img src="https://res.cloudinary.com/dxfq3iotg/image/upload/v1560918647/user.svg" alt=""></div>
		                                <div><a href="#">Registrar</a></div>
		                                <div><a href="#">Acceder</a></div>
		                            </div>
		                        </div>
		                    </div>
		                </div>
		            </div>
		        </div> <!-- Header Main -->
		        
		        <nav class="main_nav">
		            <div class="container">
		                <div class="row justify-content-md-center">
		                    <div class="col-auto text-center">
		                        <div class="main_nav_content d-flex flex-row">
		                            <!-- Categories Menu -->
		                            <!-- Main Nav Menu -->
		                            <div class="main_nav_menu">
		                                <ul class="standard_dropdown main_nav_dropdown">
		                                    <li><a href="#">Productos<i class="fas fa-chevron-down"></i></a></li>
		                                    <li><a href="#">Alta usuairos<i class="fas fa-chevron-down"></i></a></li>
		                                    <li><a href="#">Alta productos<i class="fas fa-chevron-down"></i></a></li>
		                                    <li><a href="#">Listado usuarios<i class="fas fa-chevron-down"></i></a></li>
		                                    
		                                    <!-- 
		                                     <li class="hassubs"> <a href="#">Laptop<i class="fas fa-chevron-down"></i></a>
		                                        <ul>
		                                            <li> <a href="#">Lenovo<i class="fas fa-chevron-down"></i></a>
		                                                <ul>
		                                                    <li><a href="#">Lenovo 1<i class="fas fa-chevron-down"></i></a></li>
		                                                    <li><a href="#">Lenovo 3<i class="fas fa-chevron-down"></i></a></li>
		                                                    <li><a href="#">Lenovo 2<i class="fas fa-chevron-down"></i></a></li>
		                                                </ul>
		                                            </li>
		                                            <li><a href="#">DELL<i class="fas fa-chevron-down"></i></a></li>
		                                            <li><a href="#">APPLE<i class="fas fa-chevron-down"></i></a></li>
		                                            <li><a href="#">HP<i class="fas fa-chevron-down"></i></a></li>
		                                        </ul>
		                                    </li> 
		                                    -->
		                                </ul>
		                            </div> <!-- Menu Trigger -->
		                            <div class="menu_trigger_container ml-auto">
		                                <div class="menu_trigger d-flex flex-row align-items-center justify-content-end">
		                                    <div class="menu_burger">
		                                        <div class="menu_trigger_text">menu</div>
		                                        <div class="cat_burger menu_burger_inner"><span></span><span></span><span></span></div>
		                                    </div>
		                                </div>
		                            </div>
		                        </div>
		                    </div>
		                </div>
		            </div>
		        </nav>
		    </header>
		</div>
		<script src="header.js"></script>
	</body>
</html>