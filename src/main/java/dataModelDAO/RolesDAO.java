package dataModelDAO;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import dataModelEntities.Roles;
import servlet.Loggin;

public abstract class RolesDAO {
	
	private static Logger logger = LogManager.getLogger(Loggin.class);
	
	//INSERCCION DE UN NUEVO ROL
	public static void insertRol(Session s, Roles rol) {
		s.save(rol);
		logger.debug("Inserccion del rol con el codigo: " + rol.getId());
	}
	
	//OBTENCION DE TODOS LOS ROLES DE LA TABLA
	public static List<Roles> getAllRoles(Session s){
		
		logger.debug("Obtencion de los datos de la tabla roles");
		
		String hQuery = "from Roles";
		List<Roles> listRoles = s.createQuery(hQuery, Roles.class).list();
		
		return listRoles;
		
	}
	
	//OBTENCION DE UN ROL SEGUN SU ID
	public static Roles getRol(Session s, int codigoRol) {
		logger.debug("Peticion del rol con id: " + codigoRol);
		
		Roles rol = s.get(Roles.class, codigoRol);
		
		return rol;
		
	}
	
	//BORRADO DE UN OBJETO ROL
	public static void deleteRol(Session s, int codigoRol) {
		
		Roles rol = s.get(Roles.class, codigoRol);
		
		s.delete(rol);
		
		logger.debug("Borrado del rol: " + rol.getRol());
	}
	
	//ACTUALIZACION DEL OBJETO ROL
	public static void updateRol(Session s, int codigoRol, Roles rolNuevo) {
		
		Roles rol = s.get(Roles.class, codigoRol);
		
		rol.setId(rolNuevo.getId());
		rol.setRol(rolNuevo.getRol());
		
		s.update(rol);
		
		logger.debug("Actualizacion del rol: " + rol.getRol() + " por el rol " + rolNuevo.getRol());
	}

}
