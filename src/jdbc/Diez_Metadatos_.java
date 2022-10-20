package jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Diez_Metadatos_ {

	public static void main(String[] args) {
		
		//mostrarInfo_BBDD();//como se llama el metodo directamente, el metodo debe de ser Static

		mostrarInfo_Tablas();
	}
	
	//como se llamará desde el main, esto es, no siendo parte de ninguna instancia de clase
	//el metodo debe ser tambien Static
	public static void mostrarInfo_BBDD() {
		
		Connection miConnection = null;
		
		try {
			String url = "jdbc:mysql://localhost:3306/pruebas_java?serverTimezone=UTC&useSSL=false";
			miConnection = DriverManager.getConnection(url,"root","");
			
			//obtencion de metadatos
			DatabaseMetaData datosBBDD = miConnection.getMetaData();
			
			//mostramos informacion
			System.out.println("Gestor de BBDD: "+datosBBDD.getDatabaseProductName());
			System.out.println("Version del gestor: "+datosBBDD.getDatabaseProductVersion());
			System.out.println("Nombre del driver: "+datosBBDD.getDriverName());
			System.out.println("Version del driver: "+datosBBDD.getDriverVersion());
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			try {
				miConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void mostrarInfo_Tablas() {
		
		Connection miConnection = null;
		ResultSet miResultSet = null;
		
		try {
			String url = "jdbc:mysql://localhost:3306/pruebas_java?serverTimezone=UTC&useSSL=false";
			miConnection = DriverManager.getConnection(url,"root","");
			
			//obtencion de metadatos
			DatabaseMetaData datosBBDD = miConnection.getMetaData();
			
			//obtener informacion de las tablas
			//lista de tablas
			System.out.println("Lista de tablas en BBDD:");
				miResultSet = datosBBDD.getTables("pruebas_java", null, null, null);// caracter comodin '%'
												//**(BBDD específica, null, null, null)
			if (miResultSet.next() == false) {
				System.out.println("No hay nada");
			}else {
				do {
					System.out.println(miResultSet.getString("TABLE_NAME"));
				} while (miResultSet.next());
			}
				//miResultSet.close();
			
			//Lista de columnas de tabla 'Productos'
			System.out.println("\n");
			System.out.println("Campos de productos");
			
				miResultSet= datosBBDD.getColumns("pruebas_java", null, "productos", null);
				//miResultSet.first();
			if (miResultSet.next()==false) {
				System.out.println("Nada");
			}else {
				do {
					System.out.println(miResultSet.getString("COLUMN_NAME"));
				} while (miResultSet.next());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				miConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
