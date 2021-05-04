package dataModelDAO;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dataModelEntities.Categorias;
import dataModelUtils.HibernateUtil;
import servlet.Loggin;

public abstract class CategoriasDAO {
	
	private static Logger logger = LogManager.getLogger(Loggin.class);
	
	static SessionFactory sessionFactory;
	static Session s = HibernateUtil.getSessionFactory().openSession();
	
	
	//INSERCCION DE UNA NUEVA CATEGORIA
	public static void insertCategoria(Session s, Categorias categoria) {
		s.save(categoria);
		logger.debug("Inserccion de la categoria con codigo: " + categoria.getId());
	}
	
	//OBTENCION DE TODAS LAS CATEGORIA DE LA TABLA
	public static List<Categorias> getAllCategorias(){
		
		logger.debug("Obtencion de los datos de la tabla categorias");
		
		String hQuery = "from Categorias";
		List<Categorias> listCategorias = s.createQuery(hQuery, Categorias.class).list();
		
		return listCategorias;
		
	}
	
	//OBTENCION DE UNA CATEGORIA SEGUN SU ID
	public static Categorias getCategoria(int codigoCategoria) {
		logger.debug("Peticion dela categoria con id: " + codigoCategoria);
		
		Categorias categoria = s.get(Categorias.class, codigoCategoria);
		
		return categoria;
		
	}
	
	//BORRADO DE UN OBJETO CATEGORIA
	public static void deleteCategoria(int codigoCategoria) {
		
		Categorias categoria = s.get(Categorias.class, codigoCategoria);
		
		s.delete(categoria);
		
		logger.debug("Borrado de la categoria: " + categoria.getNombre());
	}
	
	//ACTUALIZACION DEL OBJETO CATEGORIA
	public static void updateCategoria(int codigoCategoria, Categorias nuevaCategoria) {
		
		Categorias categoria = s.get(Categorias.class, codigoCategoria);
		
		categoria.setId(nuevaCategoria.getId());
		categoria.setNombre(nuevaCategoria.getNombre());
		categoria.setDescripcion(nuevaCategoria.getDescripcion());
		
		s.update(categoria);
		
		logger.debug("Actualizacion de la categoria: " + categoria.getNombre());
	}

}
