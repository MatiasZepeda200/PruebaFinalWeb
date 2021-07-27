package cl.inacap.cBancoModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import cl.inacap.cBancoModel.dto.Cliente;
import cl.inacap.cBancoModel.utils.DB;


/**
 * Session Bean implementation class ClientesDAO
 */
@Stateless
@LocalBean

public class ClientesDAO implements ClientesDAOLocal {

	private DB db = new DB(); 
	int id;
	String correoV;
	String correo;
	private static List<Cliente> clientes = new ArrayList<>();
    /**
     * Default constructor. 
     */

	public List<Cliente> getAll() {
		try {
			List<Cliente> cliente = new ArrayList<Cliente>();
			db.conectar();
			String sql = "SELECT rut, clave  FROM cliente";
			PreparedStatement st = db.getCon().prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {// va avanzando viendo si esta o no el tipo
				Cliente c = new Cliente();
				c.setRut(rs.getString(1));
				c.setClaveRut(rs.getString(2));
			}
			return cliente;
			
		} catch (Exception ex) {
			return null;
		}finally {
			db.desconectar();
		}
		
	}

	@Override
	public List<Cliente> movimientos() {
		return clientes;
	}

	@Override
	public void save(Cliente c) {
		try {
			db.conectar();
			String sqlc = "SELECT idmovimientos,cuenta_idcuenta FROM movimientos";
			PreparedStatement stc = db.getCon().prepareStatement(sqlc);
			ResultSet rs = stc.executeQuery();
			while (rs.next()) {// va avanzando viendo si esta o no el tipo
				Cliente cv = new Cliente();
				cv.setIdMovimiento(rs.getInt(1));
				cv.setSaldo(rs.getInt(2));
				int correo = cv.getSaldo();
				id = cv.getIdMovimiento();
				if (correo<=0) {
					id=0;
				}
				id = id+1;
				c.setIdMovimiento(id);
				
			}
		} catch (Exception ex) {
			
		}finally {
			db.desconectar();
			
		}
		try {
			db.conectar();
			String sql = "INSERT INTO movimientos (idmovimientos, descripcion, cuenta_idcuenta) VALUES(?,?,?)";
			PreparedStatement st = db.getCon().prepareStatement(sql);
			st.setInt(1,c.getIdMovimiento());
			st.setString(2,c.getDescripcion());
			st.setInt(3,c.getIdCuenta());
			st.executeUpdate();
		} catch (Exception ex) {
			
		}finally {
			db.desconectar();
			
		}
		try {
			db.conectar();
			String sqlc = "SELECT idmovimientos,cuenta_idcuenta FROM movimientos";
			PreparedStatement stc = db.getCon().prepareStatement(sqlc);
			ResultSet rs = stc.executeQuery();
			while (rs.next()) {// va avanzando viendo si esta o no el tipo
				Cliente cv = new Cliente();
				cv.setIdMovimiento(rs.getInt(1));
				cv.setSaldo(rs.getInt(2));
				int correo = cv.getSaldo();
				id = cv.getIdMovimiento();
				if (correo<=0) {
					id=0;
				}
				id = id+1;
				c.setIdMovimiento(id);
				
			}
		} catch (Exception ex) {
			
		}finally {
			db.desconectar();
		}
		
		int cantidad = c.getMonto();
		int persona = c.getIdCuenta();
		int recibidor =c.getIdDestino();
		int total=0;
		int finalmente;
		String descripcion =  "Se le deposito $"+cantidad+" desde la cuenta"+persona+".";
		
		try {
			db.conectar();
			String sql = "INSERT INTO movimientos (idmovimientos, descripcion, cuenta_idcuenta) VALUES(?,?,?)";
			PreparedStatement st = db.getCon().prepareStatement(sql);
			st.setInt(1,c.getIdMovimiento());
			st.setString(2,descripcion);
			st.setInt(3,c.getIdDestino());
			st.executeUpdate();
		} catch (Exception ex) {
			
		}finally {
			db.desconectar();
		}
		
		try {
			db.conectar();
			String sqlc = "SELECT saldo,idcuenta FROM cuenta WHERE idcuenta='"+persona+"'";
			PreparedStatement stc = db.getCon().prepareStatement(sqlc);
			ResultSet rs = stc.executeQuery();
			while (rs.next()) {// va avanzando viendo si esta o no el tipo
				Cliente cv = new Cliente();
				cv.setSaldo(rs.getInt(1));
				cv.setIdMovimiento(rs.getInt(2));
				int correo = cv.getSaldo();
				id = cv.getIdMovimiento();
				if (correo<=0) {
					id=0;
				}
				id = id+1;
				c.setIdMovimiento(id);
				total=cv.getSaldo();
			}
		} catch (Exception ex) {
			
		}finally {
			db.desconectar();	
		}
		
		finalmente=total-cantidad;
		
		try {
			db.conectar();
			String sqlf = "UPDATE cuenta SET saldo = '"+finalmente+"' WHERE idcuenta = '"+persona+"'";
			PreparedStatement stf = db.getCon().prepareStatement(sqlf);
			stf.executeUpdate();
		} catch (Exception ex) {
			
		}finally {
			db.desconectar();
		}
		
		try {
			db.conectar();
			String sqlc = "SELECT saldo,idcuenta FROM cuenta WHERE idcuenta='"+recibidor+"'";
			PreparedStatement stc = db.getCon().prepareStatement(sqlc);
			ResultSet rs = stc.executeQuery();
			while (rs.next()) {// va avanzando viendo si esta o no el tipo
				Cliente cv = new Cliente();
				cv.setSaldo(rs.getInt(1));
				cv.setIdMovimiento(rs.getInt(2));
				int correo = cv.getSaldo();
				id = cv.getIdMovimiento();
				if (correo<=0) {
					id=0;
				}
				id = id+1;
				c.setIdMovimiento(id);
				total=cv.getSaldo();
				
			}
		} catch (Exception ex) {
			
		}finally {
			db.desconectar();
		}
		finalmente=total+cantidad;
		try {
			db.conectar();
			String sqlf = "UPDATE cuenta SET saldo = '"+finalmente+"' WHERE idcuenta = '"+recibidor+"'";
			PreparedStatement stf = db.getCon().prepareStatement(sqlf);
			stf.executeUpdate();
		} catch (Exception ex) {
			
		}finally {
			db.desconectar();
		}
		clientes.add(c);
	}

	@Override
	public void delete(Cliente s) {
		// TODO Auto-generated method stub
		clientes.remove(s);
	}

	@Override
	public void saldo(Cliente s) {
		
		clientes.add(s);
	}

}
