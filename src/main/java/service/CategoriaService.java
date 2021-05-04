package service;

import java.util.ArrayList;

import dataModelDAO.CategoriasDAO;
import dataModelEntities.Categorias;

public class CategoriaService {

	public static ArrayList<Categorias> getAllCategorias(){
		
		return (ArrayList<Categorias>) CategoriasDAO.getAllCategorias();
		
	}
}
