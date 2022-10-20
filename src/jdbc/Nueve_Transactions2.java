package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Nueve_Transactions2 {

	public static void main(String[] args) {
		
		
		Connection miConexion = null;
		try {
			String url = "jdbc:mysql://localhost:3306/pruebas_java?serverTimezone=UTC&useSSL=false";
			
			miConexion = DriverManager.getConnection(url,"root","");
				miConexion.setAutoCommit(false);//***
			
			Statement miStatement = miConexion.createStatement();
			
			String query1 = "DELETE FROM PRODUCTOS WHERE PAÍSDEORIGEN='ITALIA'";
			String query2 = "DELETE FROM PRODUCTOS WHERE PRECIO>300";
			String query3 = "UPDATE PRODUCTOS SET PRECIO=PRECIO*1.15";
			
			boolean ejecutar = ejecutar_transaccion();
			
			if (ejecutar == true) {
				
				miStatement.executeUpdate(query1);//que sean executeUpdate|
				miStatement.executeUpdate(query2);
				miStatement.executeUpdate(query3);
				
				miConexion.commit();
				System.out.println("Todo correcto");
			}else {
				System.out.println("No se realizó ningún cambio en BBDD");
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			try {
				
				if (miConexion != null) {
					miConexion.rollback();
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Something went wrong");
		}

	}
	
	static boolean ejecutar_transaccion() {
		
		int ejecucion = JOptionPane.showConfirmDialog(null, "¿Ejecutamos la transacción?", "Pregunta", JOptionPane.YES_NO_OPTION);
		if (ejecucion==JOptionPane.YES_OPTION) {
			return true;
		}else {
			return false;
		}
	}

}
