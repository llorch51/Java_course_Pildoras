package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;



public class Carga_Info {
	
	public Carga_Info() {
		miConexion = new Conexion();
	}
	
	public String ejecutaConsultas() {//cargará las secciones al JCOmboBox
		
		Productos miProducto = null;
		Connection accesoBBDD = miConexion.dameConexion();
		
		try {
			
			Statement secciones = accesoBBDD.createStatement();
			String sqlSecciones = "SELECT SECCIÓN FROM productos GROUP BY SECCIÓN";
			
				rs = secciones.executeQuery(sqlSecciones);
				
			Statement paises = accesoBBDD.createStatement();
			String sqlPaises = "SELECT PAÍSDEORIGEN FROM productos GROUP BY PAÍSDEORIGEN";
				
				rs2 = paises.executeQuery(sqlPaises);
				
//			if (rs.next() == false) {
//				
//				System.out.println("Nel");// si RS no trae nada
//			} else {// si sí trae algo
//
//				do {//obtener las secciones del ResultSet
					miProducto = new Productos();//cada seccion en un objeto de tipo Productos
					miProducto.setSeccion(rs.getString(1));
					miProducto.setPais_origen(rs2.getString(1));
//				
//					return miProducto.getSeccion();
//					
//				} while (rs.next());
//			}
			rs.close();
			rs2.close();
			accesoBBDD.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return miProducto.getSeccion();
	}
	
	public Conexion miConexion;
	public ResultSet rs, rs2;

}
