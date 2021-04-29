package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dataModelDAO.RolesDAO;
import dataModelDAO.UsuariosDAO;
import dataModelEntities.Roles;
import dataModelEntities.Usuarios;
import dataModelUtils.HibernateUtil;

/**
 * Servlet implementation class AltaUsuarios
 */
@WebServlet("/AltaUsuarios")
public class AltaUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = LogManager.getLogger(Loggin.class);
	
	static SessionFactory sessionFactory;
	static Session session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaUsuarios() {
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
		
		int idrol = Integer.parseInt(request.getParameter("idRol"));
		Roles rol = RolesDAO.getRol(session, idrol);
		
		String email = request.getParameter("email");
		String clave = request.getParameter("clave");
		String nombre = request.getParameter("nombre");
		String apellido1 = request.getParameter("apellido1");
		String apellido2 = request.getParameter("apellido2");
		String direccion = request.getParameter("direccion");
		String localidad = request.getParameter("localidad");
		String provincia = request.getParameter("provincia");
		String telefono = request.getParameter("telefono");
		String dni = request.getParameter("dni");
		
		Usuarios user = new Usuarios(rol, email, clave, nombre, apellido1, apellido2, direccion, localidad, provincia, telefono, dni);
		
		PrintWriter out = response.getWriter();
		
		if(insertarBBDD(user)) {
			
			printResponse(out, "Usuario registrado");
			
		}else {
			
			printResponse(out, "Error al registrar el usuario");
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public boolean insertarBBDD(Usuarios user) {
		
		Transaction tx = null;
		
		try {
			
			tx = session.beginTransaction();
			UsuariosDAO.insertUsuarios(session, user);
			tx.commit();
			
			
		}catch(Exception e) {
			
			if(tx != null) {
				
				tx.rollback();
				return false;
			}
		}
		
		return true;
		
	}
	
	private PrintWriter printResponse(PrintWriter out, String texto) {
		
		//CODIGO HTML EL CUAL ESCRIBE EN PANTALLA
		PrintWriter res = out;
		
		res.println("<html>");
		res.println("<title>Ejercicio Serverlet | Sergio Alonso</title>");
		res.println("<body>");
		res.println("<h1>" + texto + "</h1>");		

		res.println("</table>");
		res.println("</body>");
		res.println("</html>");
		
		return res;
	}

}
