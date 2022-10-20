package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Tres_PreparedStatement {

	public static void main(String[] args) {
		
		
		try {
			
			//1-crear la conexion
			String url = "jdbc:mysql://localhost:3306/curso_sql?serverTimezone=UTC&useSSL=false";
			Connection miConexion = DriverManager.getConnection(url, "root", "");
			
			//2-Preparar la consulta
			String sql = "SELECT NOMBREARTÍCULO, SECCIÓN, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=? AND PAÍSDEORIGEN=?";
			PreparedStatement miPS = miConexion.prepareStatement(sql);
			
			//2.1-Establecer parametros de consulta
				miPS.setString(1, "DEPORTES");//(lugar de la '?' en la query SQL, "String por el cual cambiar")
				miPS.setString(2, "USA");
				
			//3- ejecutar y recorrer consulta
			ResultSet rs = miPS.executeQuery();
			
//			if(rs.next()==false) {
//				System.out.println("No se arrojan resultados");
//			}else {
//				
//				while(rs.next()) {//getString porque toda la información que muestro es tipo texto
//					System.out.println(rs.getString(1) + " " + rs.getString(2) +
//							" " + rs.getString(3));
//				}
//			}
			
			
			if(rs.next()==false) {//checar con un if, primero, si el RS viene vacio, o sea que no hay resultados
				System.out.println("No hay");
			}else {
				
				do {//si no viene vacio, se muestra información con DO-WHILE, porque si se hace con WHILE, se come una fila
					System.out.println(rs.getString(1) + " " + rs.getString(2) +
							" " + rs.getString(3));
				} while (rs.next());
			}
			
			
			
			//cerrar ResultSet
				rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
