package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Uno_jdbc_BBDD {

	public static void main(String[] args) {
		
		try {
			
			//1-crear conexion
			String url = "jdbc:mysql://localhost:3306/pruebas_java?serverTimezone=UTC&useSSL=false";
			Connection miConexion = DriverManager.getConnection(url, "root", "");
			
			//2-Objeto Statement
			Statement miStatement = miConexion.createStatement();
			
			//3-ejecutar SQLxterna
			String sql = "SELECT * FROM productos";
			ResultSet miRes = miStatement.executeQuery(sql);
			
			//4-leer el ResultSet-es como  una tabla en memoria en donde se almacena lo que queremos ver
			while(miRes.next()) {
				System.out.println(miRes.getString("NOMBREARTÍCULO") + " " + miRes.getString("CÓDIGOARTÍCULO") +
						" " + miRes.getString("PRECIO"));
			}
			
			//Cerrar ResultSet
				miRes.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
