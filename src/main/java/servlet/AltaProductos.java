package servlet;

import java.io.IOException;
import java.util.Date;

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

import dataModelDAO.ProductosDAO;
import dataModelEntities.Productos;
import dataModelUtils.HibernateUtil;

/**
 * Servlet implementation class AltaProductos
 */
public class AltaProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static Logger logger = LogManager.getLogger(Loggin.class);
	
	static SessionFactory sessionFactory;
	static Session session;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaProductos() {
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
		
		
		logger.debug("Inserccion de un nuevo producto");
		
		//CREACION DEL TRANSACTION PARA REALIZAR LA INSERCCION
		Transaction tx = session.beginTransaction();
		
		try {
			
			int idCategoria = Integer.parseInt(request.getParameter("id"));
			String nombre = request.getParameter("nombre");
			String descripcion = request.getParameter("descripcion");
			double precio = Double.parseDouble(request.getParameter("precio"));
			int stock = Integer.parseInt(request.getParameter("stock"));
			Date fechaAlta = new Date(request.getParameter("fechaAlta"));
			Date fechaBaja = new Date(request.getParameter("fechaBaja"));
			float impuesto = Float.parseFloat(request.getParameter("impuesto"));
			
			//CREACION DEL OBJETO PRODUCTO CON LOS PARAMETROS OBTENIDOS
			Productos producto = new Productos(idCategoria, nombre, descripcion, precio, stock, fechaAlta, fechaBaja, impuesto);		
			
			//INSERCCION DEL PRODUCTO EN LA BASE DE DATOS
			ProductosDAO.insertProducto(session, producto);
			
			logger.debug("Producto registrado como: " + nombre);
			
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
