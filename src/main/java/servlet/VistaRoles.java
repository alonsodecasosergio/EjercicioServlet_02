package servlet;

import java.io.IOException;
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

import dataModelDAO.RolesDAO;
import dataModelEntities.Roles;
import dataModelUtils.HibernateUtil;

/**
 * Servlet implementation class VistaRoles
 */
@WebServlet("/VistaRoles")
public class VistaRoles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static Logger logger = LogManager.getLogger(Loggin.class);
	
	static SessionFactory sessionFactory;
	static Session session;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VistaRoles() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		logger.info("%1$s: >>>>>> Main execution started.VISUALIZAR ROLES");
		
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
		
		List<Roles> rolesList = RolesDAO.getAllRoles(session);
		
		HttpSession session = request.getSession(true);
		session.setAttribute("rolesList",  rolesList);
		request.getRequestDispatcher("VistaRoles.jsp").forward(request, response);
	}

}
