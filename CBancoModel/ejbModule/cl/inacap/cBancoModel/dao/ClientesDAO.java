package cl.inacap.cBancoModel.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import cl.inacap.cBancoModel.dto.Cliente;

/**
 * Session Bean implementation class ClientesDAO
 */
@Stateless
@LocalBean
public class ClientesDAO implements ClientesDAOLocal {

	private static List<Cliente> clientes = new ArrayList<>();
    /**
     * Default constructor. 
     */
    public ClientesDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Cliente> getAll() {
		// TODO Auto-generated method stub
		return clientes;
	}

	@Override
	public List<Cliente> movimientos() {
		// Este mostrara los movimientos desde el mysql
		return null;
	}

	@Override
	public void save(Cliente c) {
		//Este guardara los movimientos
		
	}

	@Override
	public void delete(Cliente s) {
		// TODO Auto-generated method stub
		clientes.remove(s);
	}

	@Override
	public void saldo(Cliente s) {
		// TODO Auto-generated method stub
		clientes.add(s);
	}

}
