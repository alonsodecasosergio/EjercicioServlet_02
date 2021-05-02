package servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dataModelDAO.CategoriasDAO;
import dataModelEntities.Categorias;
import dataModelUtils.HibernateUtil;

/**
 * Servlet implementation class AltaCategorias
 */
public class AltaCategorias extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static Logger logger = LogManager.getLogger(Loggin.class);
	
	static SessionFactory sessionFactory;
	static Session session;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaCategorias() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger.debug("Inserccion de una nueva categoria");
		
		//CREACION DEL TRANSACTION PARA REALIZAR LA INSERCCION
		Transaction tx = session.beginTransaction();
		
		try {
			
			String nombre = request.getParameter("nombre");
			String descripcion = request.getParameter("descripcion");
			
			//CREACION DEL OBJETO CATEGORIA CON LOS PARAMETROS OBTENIDOS
			Categorias categoria = new Categorias(nombre, descripcion);		
			
			//INSERCCION DEL LA CATEGORIA EN LA BASE DE DATOS
			CategoriasDAO.insertCategoria(session, categoria);
			
			logger.debug("Categoria registrado como: " + nombre);
			
			//DEPENDIENDO DEL ROL ASIGNADO OBTENDRA EL NOMBRE DE UNA VISTA U OTRA PARA VOLVER AL MENU SEGUN EL ROL DEL USUARIO
			HttpSession sessionHtml = request.getSession(true);
			String redireccion = sessionHtml.getAttribute("Menu").toString();
			
			tx.commit();

			request.getRequestDispatcher(redireccion).forward(request, response);
			
		}catch(Exception e) {
			
			if(tx != null) {
				 tx.rollback();
				 logger.debug("Error al registrar la categoria");
			}
		}
	}

}
