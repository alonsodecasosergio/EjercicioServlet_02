package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dataModelDAO.UsuariosDAO;
import dataModelEntities.Usuarios;
import dataModelUtils.HibernateUtil;

/**
 * Servlet implementation class Loggin
 */
@WebServlet("/Loggin")
public class Loggin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = LogManager.getLogger(Loggin.class);
	
	static SessionFactory sessionFactory;
	static Session session;
       
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
		
		session = HibernateUtil.getSessionFactory().openSession();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//OBTIENE LOS PARAMETROS DE LA URL
		String parametroUsuario = request.getParameter("login");
		String parametroPassword = request.getParameter("password");
		
		logger.debug("Intento de acceso con: " + parametroUsuario + " " + parametroPassword);
		
		//LOS PASA AL METODO QUE COMPROBARA SI SON CORRECTOS
		comprobarUsuario(parametroUsuario, parametroPassword, response, request);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void comprobarUsuario(String usuario, String password, HttpServletResponse response, HttpServletRequest request) throws IOException, ServletException {
		
		//OBTENCION DEL USUARIO CON ESE EMAIL
		Usuarios user = UsuariosDAO.getUsuarioToEmail(session, usuario);
		PrintWriter out = response.getWriter();
		
		//SI EL USUARIO NO EXISTE SALTA UN MENSAJE SI EXISTE COMPRUEBA EL USUARIO Y CONTRASEÑA
		if(user != null) {
			
			if(user.getEmail().equals(usuario) && user.getClave().equals(password)) {
				
				//SI ESTA BIEN ESCRIBE UN MENSAJE CON EL NOMBRE DEL USUARIO
				
				logger.debug("El usuario ha sido introducido correctamente");
				
				Date date = new Date();
				DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
				System.out.println("Hora y fecha: "+hourdateFormat.format(date));
				
				HttpSession session = request.getSession(true);
				session.setAttribute("clientName", user.getNombre() + " " + user.getApellido1() + " " + user.getApellido2() + "->" + hourdateFormat.format(date));
				request.getRequestDispatcher("PanelPrincipal.jsp").forward(request, response);
				
			}else {				
				logger.debug("El usuario no es correcto");
			}
			
		}else {

			//SI NO ES CORRECTO INFORMA DE QUE NO PUEDE ACCEDER
			logger.debug("El usuario no es correcto");
		}
		
	}

}
