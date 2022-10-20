package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Siete_CallableStatement2_Update {
	//procedimiento almacenado
	/*en BBDD
	CREATE PROCEDURE ACTUALIZA_PRODUCTO(NUEVO_PRECIO INT, NOM_ARTICULO VARCHAR(20))
	UPDATE productos SET PRECIO=NUEVO_PRECIO WHERE NOMBREARTÍCULO=NOM_ARTICULO;
	
	*/
	public static void main(String[] args) {
		
		int Precio = Integer.parseInt(JOptionPane.showInputDialog("Intoduce precio"));
		String Articulo = JOptionPane.showInputDialog("Introduce nombre de articulo").toUpperCase();
		
		try {
			String url = "jdbc:mysql://localhost:3306/curso_sql?serverTimezone=UTC&useSSL=false";
			Connection miConexion = DriverManager.getConnection(url, "root", "");
			
			CallableStatement miStatement2 = miConexion.prepareCall("{call ACTUALIZA_PRODUCTO(?, ?)}");//(?, ?)-PARAMETROS DEFINIDOS en procedimiento almacenado
				miStatement2.setInt(1, Precio);
				miStatement2.setString(2, Articulo);
				miStatement2.execute();//para que NO regrese un ResultSet
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
