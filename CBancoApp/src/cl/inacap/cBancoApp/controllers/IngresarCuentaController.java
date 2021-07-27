package cl.inacap.cBancoApp.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.inacap.cBancoModel.dao.ClientesDAO;
import cl.inacap.cBancoModel.dao.ClientesDAOLocal;
import cl.inacap.cBancoModel.dto.Cliente;



/**
 * Servlet implementation class IngresarCuentaController
 */
@WebServlet("/IngresarCuentaController.do")
public class IngresarCuentaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private ClientesDAOLocal clientesDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IngresarCuentaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/vistas/ingresarCuenta.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<String> errores = new ArrayList<>();
		List<String> verificadores = new ArrayList<>();


		String rutR = request.getParameter("rut-txt").trim();
		if (rutR.isEmpty()) {
			errores.add("Ingrese un rut");
		}
		String claveR = request.getParameter("clave-txt").trim();
		if (claveR.isEmpty()) {
			errores.add("Ingrese una clave");
		}
		
		List<Cliente> cliente = new ClientesDAO().getAll();
			cliente.forEach(c->{
				String rut = c.getRut();
				String clave = c.getClaveRut();
				
				if (rutR==rut) {
					if (claveR==clave) {
						verificadores.add("correcto");
					}else {
						errores.add("Clave Incorrecta");
					}
				}else {
					errores.add("Ingrese un rut existente");
				}
			});
		if (errores.isEmpty()) {
			RequestDispatcher rd;
			rd=request.getRequestDispatcher("Indexs.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("errores",errores);
		}
		doGet(request, response);
	}

}
