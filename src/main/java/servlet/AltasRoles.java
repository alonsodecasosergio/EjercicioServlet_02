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
import dataModelEntities.Roles;
import dataModelUtils.HibernateUtil;

/**
 * Servlet implementation class AltasRoles
 */
@WebServlet("/AltasRoles")
public class AltasRoles extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static Logger logger = LogManager.getLogger(AltasRoles.class);
	
	static SessionFactory sessionFactory;
	static Session session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltasRoles() {
        super();
        // TODO Auto-generated constructor stub
    }
    
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		logger.debug("Inserccion de un nuevo rol");
		
		//CREACION DEL TRANSACTION PARA REALIZAR LA INSERCCION
		Transaction tx = session.beginTransaction();
		PrintWriter out = response.getWriter();
		
		try {
			
			String nombre = request.getParameter("nombre");
			
			//CREACION DEL OBJETO ROL CON LOS PARAMETROS OBTENIDOS
			Roles rol = new Roles(nombre);			
			
			//INSERCCION DEL ROL EN LA BASE DE DATOS
			RolesDAO.insertRol(session, rol);
			
			logger.debug("Rol registrado como: " + nombre);
			
			printResponse(out, "Rol registrado");
			
			tx.commit();
			
		}catch(Exception e) {
			
			if(tx != null) {
				 tx.rollback();
				 logger.debug("Error al registrar el rol");
				 printResponse(out, "Error al registrar el rol");
			}
		}
	}

}
