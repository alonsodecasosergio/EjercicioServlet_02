package service;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import dataModelDAO.UsuariosDAO;
import dataModelEntities.Usuarios;
import servlet.Loggin;

public class UsuariosService {
	
	private static Logger logger = LogManager.getLogger(Loggin.class);
	
	public static Usuarios obtenerUsuario(String email, String password) {
		
		Usuarios user = UsuariosDAO.getUsuarioToEmail(email);
		
		if(user != null) {
			
			if(user.getEmail().equals(email) && user.getClave().equals(password)) {
				
				logger.debug("El usuario correcto");
				
				return user;
				
			}else {				
				logger.debug("El usuario no es correcto");
			}
			
		}else {

			//SI NO ES CORRECTO INFORMA DE QUE NO PUEDE ACCEDER
			logger.debug("El usuario no es correcto");
		}
		
		user = null;
		
		return user;
	}

	public static boolean comprobarUsuario(String email, String password) {
		
		Usuarios user = UsuariosDAO.getUsuarioToEmail(email);
		
		if(user != null) {
			
			if(user.getEmail().equals(email) && user.getClave().equals(password)) {
				
				logger.debug("El usuario correcto");
				
				return true;
				
			}else {				
				logger.debug("El usuario no es correcto");
			}
			
		}else {

			//SI NO ES CORRECTO INFORMA DE QUE NO PUEDE ACCEDER
			logger.debug("El usuario no es correcto");
		}
		
		return false;
	}
	
	public static String getRedireccion(String rol) {
		
		String redireccion = "";
		
		if(rol.equals("Admin")) {
			
			redireccion = "MenuPrincipalAdmin.jsp";
		}else if (rol.equals("Empleado")){
			redireccion = "MenuPrincipalEmpleado.jsp";
		}else {
			redireccion = "MenuPrincipalCliente.jsp";
		}
		
		return redireccion;
	}

}
