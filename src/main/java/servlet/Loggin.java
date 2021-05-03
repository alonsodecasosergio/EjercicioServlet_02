package servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import dataModelEntities.Roles;
import dataModelEntities.Usuarios;
import service.RolService;
import service.UsuariosService;

/**
 * Servlet implementation class Loggin
 */
@WebServlet("/Loggin")
public class Loggin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = LogManager.getLogger(Loggin.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loggin() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		//INFORMACION DE INICIO DEL PROGRAMA Y INICIO DE LA SESSION DE HIBERNATE
		logger.info("%1$s: >>>>>> Main execution started. MOSTRAR DATOS");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//OBTIENE LOS PARAMETROS DE LA URL
		String parametroUsuario = request.getParameter("login");
		String parametroPassword = request.getParameter("password");
		
		logger.debug("Intento de acceso con: " + parametroUsuario + " " + parametroPassword);
		
		
		if(UsuariosService.comprobarUsuario(parametroUsuario, parametroPassword)) {
			
			Usuarios user = UsuariosService.obtenerUsuario(parametroUsuario, parametroPassword);
			
			Date date = new Date();
			DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
			System.out.println("Hora y fecha: "+hourdateFormat.format(date));
			
			Roles rol = RolService.getRol(user.getRol());
			
			HttpSession session = request.getSession(true);
			session.setAttribute("clientRol", rol.getRol());
			session.setAttribute("clientName", user.getNombre() + " " + user.getApellido1() + " " + user.getApellido2() + " | " + hourdateFormat.format(date));
			
			String redireccion = UsuariosService.getRedireccion(rol.getRol());
			
			session.setAttribute("Menu", redireccion);
			request.getRequestDispatcher(redireccion).forward(request, response);
			
			
		}else {
			response.sendRedirect("login.html");
		}
	}
}