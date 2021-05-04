package service;

import java.util.ArrayList;

import dataModelDAO.ProductosDAO;
import dataModelEntities.Productos;

public class ProductosService {

	public static ArrayList<Productos> getAllProductos() {
		
		return (ArrayList<Productos>) ProductosDAO.getAllProductos();
		
	}
}
