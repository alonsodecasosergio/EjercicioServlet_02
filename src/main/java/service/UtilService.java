package service;

import org.jasypt.util.password.BasicPasswordEncryptor;
import org.jasypt.util.password.PasswordEncryptor;

public class UtilService {

	
	public static String encryptedPassword(String password) {
		
		PasswordEncryptor encryptor = new BasicPasswordEncryptor();
        
        String encryptedPassword = encryptor.encryptPassword(password);
        
        return encryptedPassword;
		
	}
	
	public static boolean desencryptedPassword(String userPassword, String password) {
		
		PasswordEncryptor encryptor = new BasicPasswordEncryptor();
        
        
        if (encryptor.checkPassword(password, userPassword )) {
            
        	return true;
        }
        
        return false;
		
	}
	
	public static void main(String[] args) {
		
		System.out.println(encryptedPassword("Sergio"));
		
		System.out.print(desencryptedPassword(encryptedPassword("Sergio"),"Sergio"));
		
	}
}
