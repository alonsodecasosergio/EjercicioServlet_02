package dataModelDAO;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import dataModelEntities.Usuarios;
import servlet.Loggin;

public abstract class UsuariosDAO {
	
	private static Logger logger = LogManager.getLogger(Loggin.class);
	
	//INSERCCION DE UN NUEVO USUARIO
	public static void insertUsuarios(Session s, Usuarios usuario) {
		
		s.save(usuario);
		logger.debug("Inserccion del rol con el codigo: " + usuario.getId());

	}
	
	//OBTENCION DE TODOS LOS USUARIOS DE LA TABLA
	public static List<Usuarios> getAllUsuarios(Session s, Usuarios usuario){
		
		logger.debug("Obtencion de los datos de la tabla de usuarios");
		
		String hQuery = "from Usuarios";
		List<Usuarios> listUsuarios = s.createQuery(hQuery, Usuarios.class).list();
		
		return listUsuarios;
	}
	
	//OBTENCION DE USUARIO SEGUN SU ID
	public static Usuarios getUsuario(Session s, int idUsuario) {
		
		logger.debug("Peticion del rol con id: " + idUsuario);
		
		String hQuery = " from Usuarios u where u.id = :id";
		Usuarios usuario = s.createQuery(hQuery, Usuarios.class)
									.setParameter("id", idUsuario)
									.setMaxResults(1)
									.uniqueResult();
		return usuario;
	}
	
	//BORRADO DE UN USUARIO
	public static void deleteUsuario(Session s, int idUsuario) {
		
		Usuarios usuario = s.get(Usuarios.class, idUsuario);
		
		s.delete(usuario);
		
		logger.debug("Borrado del usuario: " + usuario.getId() + " " + usuario.getNombre());
	}
	
	//ACTUALIZACION DEL OBJETO USUARIO
	public static void updateUsuario(Session s, int idUsuario, Usuarios nuevoUsuario) {
		
		Usuarios usuario = s.get(Usuarios.class, idUsuario);
		
		usuario.setId(nuevoUsuario.getId());
		usuario.setRoles(nuevoUsuario.getRoles());
		usuario.setEmail(nuevoUsuario.getEmail());
		usuario.setClave(nuevoUsuario.getClave());
		usuario.setNombre(nuevoUsuario.getNombre());
		usuario.setApellido1(nuevoUsuario.getApellido1());
		usuario.setApellido2(nuevoUsuario.getApellido2());
		usuario.setDireccion(nuevoUsuario.getDireccion());
		usuario.setLocalidad(nuevoUsuario.getLocalidad());
		usuario.setProvincia(nuevoUsuario.getProvincia());
		usuario.setTelefono(nuevoUsuario.getTelefono());
		usuario.setDni(nuevoUsuario.getDni());
		
		s.update(usuario);
		
		logger.debug("Actualizacion del usuario: " + usuario.getId() + " " + usuario.getNombre());
		
		
	}
}
