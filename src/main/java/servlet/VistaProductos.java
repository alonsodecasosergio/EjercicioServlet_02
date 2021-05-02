package servlet;

import java.io.IOException;
import java.util.List;

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

import dataModelDAO.ProductosDAO;
import dataModelEntities.Productos;
import dataModelUtils.HibernateUtil;

/**
 * Servlet implementation class VistaProductos
 */
public class VistaProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = LogManager.getLogger(Loggin.class);
	
	static SessionFactory sessionFactory;
	static Session session;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VistaProductos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		logger.info("%1$s: >>>>>> Main execution started.VISUALIZAR PRODUCTOS");
		
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
		
		List<Productos> productosList = ProductosDAO.getAllProductos(session);


		HttpSession session = request.getSession(true);
		session.setAttribute("productosList",  productosList);
		request.getRequestDispatcher("VistaProductos.jsp").forward(request, response);
	}

}
