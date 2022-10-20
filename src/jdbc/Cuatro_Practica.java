package jdbc;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Cuatro_Practica {

	public static void main(String[] args) {
		
		miFrame miMarco = new miFrame();
			miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

//***********************************************

class miFrame extends JFrame{
	
	public miFrame() {
		
		setTitle("Consulta JDBC");
		setBounds(500,300,400,400);
		
		setLayout(new BorderLayout());
		
		JButton btnConsulta = new JButton("Consulta");
			btnConsulta.addActionListener(new ActionListener() {//llamar al metodo creado
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ejecutaConsulta();
					
				}
			});
		JPanel menus = new JPanel();
			menus.setLayout(new FlowLayout());
			
			secciones=new JComboBox();
			secciones.setEditable(false);
			secciones.addItem("Todos");
			
			paises = new JComboBox();
			paises.setEditable(false);
			paises.addItem("Todos");
			
			resultado = new JTextArea(4,50);
			resultado.setEditable(false);
			
			menus.add(secciones);
			menus.add(paises);
			
		
		add(menus, BorderLayout.NORTH);
		//add(resultado);	
		add(resultado, BorderLayout.CENTER);
		add(btnConsulta, BorderLayout.SOUTH);
		
		setVisible(true);
		
		//*******************Conexion a BBDD***********************
		
		try {
			//1.-
			String url = "jdbc:mysql://localhost:3306/curso_sql?serverTimezone=UTC&useSSL=false";
			miCon = DriverManager.getConnection(url, "root", "");
			
			//2.-Preparar consulta
			Statement miStatement = miCon.createStatement();
			
			//3.-
			String sql = "SELECT SECCIÓN FROM productos GROUP BY SECCIÓN";
			ResultSet rs = miStatement.executeQuery(sql);;//RS es la tabla cargada en memoria con los resultados obtenidos
			
			if (rs.next()==false) {
				System.out.println("Nel");//si RS no trae nada
			}else {//si sí trae algo
				
				do {
					secciones.addItem(rs.getString(1));//añade los elementos de esa columna en el RS al desplegable de secciones-combobox
				} while (rs.next());
				
			}
				rs.close();
				
			
				sql = "SELECT PAÍSDEORIGEN FROM productos GROUP BY PAÍSDEORIGEN";
				rs= miStatement.executeQuery(sql);
				if (rs.next()==false) {
					System.out.println("Nel");//si RS no trae nada
				}else {//si sí trae algo
					
					do {
						paises.addItem(rs.getString(1));//añade los elementos de esa columna en el RS al desplegable de secciones-combobox
					} while (rs.next());
					
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void ejecutaConsulta() {
		
		ResultSet rs= null;
		
		try {
			resultado.setText("");
			
			String seccion = (String) secciones.getSelectedItem();//seleccion del combobox  Seccion
			String pais = (String) paises.getSelectedItem();//seleccion del combobox paises
			
			if(!seccion.equals("Todos") && pais.equals("Todos")) {//si la opcion almacenada en seccion es distinta de 'todos' y 
																//en pais es igual a 'todos', significa q algo se movió en Seccion
				miPreparedStatement=miCon.prepareStatement(querySeccion);
				miPreparedStatement.setString(1, seccion);
				
				rs=miPreparedStatement.executeQuery();
				
			}else if (seccion.equals("Todos") && !pais.equals("Todos")) {
				
				miPreparedStatement=miCon.prepareStatement(queryPais);
				miPreparedStatement.setString(1, pais);
				
				rs=miPreparedStatement.executeQuery();
				
			}else if (!seccion.equals("Todos") && !pais.equals("Todos")) {
				
				miPreparedStatement=miCon.prepareStatement(queryAmbas);
				miPreparedStatement.setString(1, seccion);
				miPreparedStatement.setString(2, pais);
				
				rs=miPreparedStatement.executeQuery();
				
			}else if (seccion.equals("Todos") && pais.equals("Todos")) {
				miPreparedStatement = miCon.prepareStatement(queryTodos);
				
				rs = miPreparedStatement.executeQuery();
			}
			
			if (rs.next()==false) {//si rs viene vacio
				System.out.println("Peluquín");
			}else {
				
				do {//mostrar en el JtextArea
					resultado.append(rs.getString(1));//corresponde al num de la columna de la tabla almacenada en ResultSet
					resultado.append(", ");
					resultado.append(rs.getString(2));
					resultado.append(", ");
					resultado.append(rs.getString(3));
					resultado.append(", ");
					resultado.append(rs.getString(4));//4 son las columnas que pedimos en las querys
					
					resultado.append("\n");//salto de linea
				} while (rs.next());
			}
				
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	private JComboBox secciones;
	private JComboBox paises;
	private JTextArea resultado;
	private Connection miCon;
	private PreparedStatement miPreparedStatement;
	private final String querySeccion = "SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM productos WHERE SECCIÓN=?";
	private final String queryPais = "SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM productos WHERE PAÍSDEORIGEN=?";
	private final String queryAmbas = "SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN "
			+ "FROM productos WHERE SECCIÓN=? AND PAÍSDEORIGEN=?";
	private final String queryTodos = "SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM productos";
}
