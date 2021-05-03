package service;

import dataModelDAO.RolesDAO;
import dataModelEntities.Roles;

public class RolService {
	
	public static Roles getRol(int id) {
		
		return RolesDAO.getRol(id);
	}

}
