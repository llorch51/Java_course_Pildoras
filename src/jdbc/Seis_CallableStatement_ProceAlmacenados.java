package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Seis_CallableStatement_ProceAlmacenados {
	
	/*En la BBDD, como query, tipear esto (ejemplo)
	 * 
	CREATE PROCEDURE MUESTRA_CLIENTES() 
	SELECT * FROM clientes WHERE POBLACIÓN="BARCELONA";
	
	*/

	public static void main(String[] args) {
		
		try {//con CallableStatement le dejamos la responsabilidad de la ejecucion de un query al servidor de BBDD
			//creando un 'procedimiento almacenado' en la misma BBDD
			//asi, no hay querys ejecutandose aqui
			
			String url = "jdbc:mysql://localhost:3306/curso_sql?serverTimezone=UTC&useSSL=false";
			Connection miConexion = DriverManager.getConnection(url, "root", "");
			
			CallableStatement miSentencia = miConexion.prepareCall("{call MUESTRA_CLIENTES}");
			ResultSet rs = miSentencia.executeQuery();
			
			if(rs.next()==false) {
				System.out.println("Nada");
			}else {
				do {
					System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
				} while (rs.next());
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
