package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	
	public Conexion() {
		
	}
	
	public Connection dameConexion() {
		
		try {
			
			miConnection = DriverManager.getConnection(url, usuario, password);
			//System.out.println("Conexión a BBDD hecha");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return miConnection;
	}
	
	Connection miConnection;
	private final String url = "jdbc:mysql://localhost:3306/curso_sql?serverTimezone=UTC&useSSL=false";
	private final String usuario = "root";
	private final String password = "";
	

}
