package cl.inacap.cBancoModel.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

	private Connection con;
	public Connection getCon() {
		return con;
	}
	public boolean conectar() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.con = DriverManager.getConnection("jdbc:mysql://localhost/pruebafinal?serverTimezone=UTC", "root", "");
			
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	public void desconectar() {
		try {
			con.close();
		} catch (Exception ex) {
			
		}
	}
}

