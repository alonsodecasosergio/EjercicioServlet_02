package dataModelDAO;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import dataModelEntities.Productos;
import servlet.Loggin;

public abstract class ProductosDAO {
	
	private static Logger logger = LogManager.getLogger(Loggin.class);
	
	//INSERCCION DE UN NUEVO PRODUCTO
	public static void insertProducto(Session s, Productos producto) {
		s.save(producto);
		logger.debug("Inserccion del producto con codigo: " + producto.getId());
	}
	
	//OBTENCION DE TODOS LOS PRODUCTOS DE LA TABLA
	public static List<Productos> getAllProductos(Session s){
		
		logger.debug("Obtencion de los datos de la tabla productos");
		
		String hQuery = "from Productos";
		List<Productos> listProductos = s.createQuery(hQuery, Productos.class).list();
		
		return listProductos;
		
	}
	
	//OBTENCION DE UN PRODUCTO SEGUN SU ID
	public static Productos getProducto(Session s, int codigoProducto) {
		logger.debug("Peticion del producto con id: " + codigoProducto);
		
		Productos producto = s.get(Productos.class, codigoProducto);
		
		return producto;
		
	}
	
	//BORRADO DE UN OBJETO PRODUCTO
	public static void deleteProducto(Session s, int codigoProducto) {
		
		Productos producto = s.get(Productos.class, codigoProducto);
		
		s.delete(producto);
		
		logger.debug("Borrado del producto: " + producto.getId() + " | " + producto.getNombre());
	}
	
	//ACTUALIZACION DEL OBJETO PRODUCTO
	public static void updateProducto(Session s, int codigoProducto, Productos nuevoProducto) {
		
		Productos producto = s.get(Productos.class, codigoProducto);
		
		producto.setId(nuevoProducto.getId());
		producto.setIdCategoria(nuevoProducto.getIdCategoria());
		producto.setNombre(nuevoProducto.getNombre());
		producto.setDescripcion(nuevoProducto.getDescripcion());
		producto.setPrecio(nuevoProducto.getPrecio());
		producto.setStock(nuevoProducto.getStock());
		producto.setFechaAlta(nuevoProducto.getFechaAlta());
		producto.setFechaBaja(nuevoProducto.getFechaBaja());
		producto.setImpuesto(nuevoProducto.getImpuesto());
		
		s.update(producto);
		
		logger.debug("Actualizacion del producto: " + producto.getId() + " | " + producto.getNombre());
	}

}
