package sbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	Connection cx = null;

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String cadena_conexion = "jdbc:mysql://Localhost:3306/grupalbd";
	private String usuario = "root";
	private String contraseña = "";

	public Connection conn() {

		try {
			Class.forName(driver);
			cx = DriverManager.getConnection(cadena_conexion, usuario, contraseña);
			System.out.println("Conectado");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return cx;

	}
}
