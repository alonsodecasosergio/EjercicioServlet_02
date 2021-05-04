package service;

import java.util.ArrayList;

import dataModelDAO.RolesDAO;
import dataModelEntities.Roles;

public class RolService {
	
	public static Roles getRol(int id) {
		
		return RolesDAO.getRol(id);
	}
	
	public static ArrayList<Roles> getAllRoles(){
		
		return (ArrayList<Roles>) RolesDAO.getAllRoles();
	}

}
