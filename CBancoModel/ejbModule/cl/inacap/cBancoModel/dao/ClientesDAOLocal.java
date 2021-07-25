package cl.inacap.cBancoModel.dao;

import java.util.List;

import javax.ejb.Local;

import cl.inacap.cBancoModel.dto.Cliente;

@Local
public interface ClientesDAOLocal {

	public List<Cliente> getAll();
	public List<Cliente> movimientos();
	public void save(Cliente c);
	public void saldo(Cliente s);
	public void delete(Cliente s);
}
