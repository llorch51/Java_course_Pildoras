package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Dos_Statement_ModificarBBDD {

	public static void main(String[] args) {
		
		try {
			
			String url = "jdbc:mysql://localhost:3306/curso_sql?serverTimezone=UTC&useSSL=false";
			Connection miConexion = DriverManager.getConnection(url, "root", "");
			
			Statement miStatement = miConexion.createStatement();
			
			//String instruccionSQL = "INSERT INTO PRODUCTOS (CÓDIGOARTÍCULO, NOMBREARTÍCULO, PRECIO) VALUES ('AR77', 'PANTALON', 23.44)";
			
				//miStatement.executeUpdate(instruccionSQL);
			System.out.println("Chido");
			
			String otraInstruccionSQL = "UPDATE PRODUCTOS SET PRECIO=PRECIO*2 WHERE CÓDIGOARTÍCULO='AR77'";
				miStatement.executeUpdate(otraInstruccionSQL);
				
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
