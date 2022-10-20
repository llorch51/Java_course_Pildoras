package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ocho_Transactions {

	public static void main(String[] args) {
		
		Connection miConexion = null;
		
		try {
			String url = "jdbc:mysql://localhost:3306/pruebas_java?serverTimezone=UTC&useSSL=false";
			miConexion = DriverManager.getConnection(url, "root", "");
				miConexion.setAutoCommit(false);//***
			
			Statement miStatement = miConexion.createStatement();
			String query1 = "INSERT INTO CLIENTES (CÓDIGOCLIENTE, EMPRESA, DIRECCIÓN) VALUES ('CT84', 'EJEMPLO', 'P BOTÁNICO')";
				miStatement.executeUpdate(query1);//que sean executeUpdate
				
			String query2 = "INSERT INTO PEDIDOS (NÚMERO_DE_PEDIDO, CÓDIGOCLIENTE, FECHA_DE_PEDIDO) VALUES ('82', 'CT84', '11/03/2000')";
				miStatement.executeUpdate(query2);
				
				miConexion.commit();//***
				
			System.out.println("chido");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Nel pastel");
			
			try {
				miConexion.rollback();//****
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}

	}

}
