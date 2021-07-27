package cl.inacap.cBancoApp.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
 * Servlet implementation class RealizarTransferenciaController
 */
@WebServlet("/RealizarTransferenciaController.do")
public class RealizarTransferenciaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       @Inject
       private ClientesDAOLocal clientesDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RealizarTransferenciaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/vistas/realizarTransaccion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<String> errores = new ArrayList<>();
		
		String origenTxt = request.getParameter("origen-txt").trim();
		int origen = 0;
		try {
			origen=Integer.parseInt(origenTxt);
		} catch (Exception ex) {
			errores.add("Ingrese un numero de cuentavalido");
		}
		String destinoTxt = request.getParameter("destino-txt").trim();
		int destino = 0;
		try {
			destino =Integer.parseInt(destinoTxt);
		} catch (Exception ex) {
			errores.add("Ingrese un numero de cuenta valido");
		}
		String montoTxt= request.getParameter("monto-txt").trim();
		int monto = 0;
		try {
			monto=Integer.parseInt(montoTxt);
		} catch (Exception ex) {
			errores.add("Ingrese un monto valido");
		}
		String claveTxt = request.getParameter("clave-txt").trim();
		int clave = 0;
		try {
			clave=Integer.parseInt(claveTxt);
		} catch (Exception ex) {
			errores.add("Ingrese una clave");
		}
		Date fecha = new Date();
		
		String descripcion = "Deposistaste $"+monto+" en la cuenta "+destino+"."; 
		
		String fechaR = fecha.toString();
		
		if (errores.isEmpty()) {
		  Cliente c = new Cliente();
		  c.setFecha(fechaR);
		  c.setClave(clave);
		  c.setIdCuenta(origen);
		  c.setIdDestino(destino);
		  c.setDescripcion(descripcion);
		  c.setMonto(monto);
		  clientesDAO.save(c);
		  RequestDispatcher rd;
			rd=request.getRequestDispatcher("Indexs.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("errores",errores);
		}
		doGet(request, response);
	}

}
