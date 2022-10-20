package jdbc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Once_Practica_ {

	public static void main(String[] args) {
		MarcoBBDD miMarcoBBDD = new MarcoBBDD();
			miMarcoBBDD.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
//***************************************
class MarcoBBDD extends JFrame{
	
	public MarcoBBDD() {
		
		setBounds(500, 300, 600, 600);
		setTitle("Conexión a BBDD");
		
		add(new LaminaBBDD());
		setVisible(true);
		
	}
}
//***************************************
class LaminaBBDD extends JPanel{
	
	public LaminaBBDD() {
		
		setLayout(new BorderLayout());
		
		
			comboTablas = new JComboBox();
			
		conectarBBDD();
		obtenerTablas();
			
			comboTablas.addActionListener(new ActionListener() {//al seleccionar opcion manda llamar metodo 'mostrarInfoTablas'
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String seleccionTabla = (String)comboTablas.getSelectedItem();
					
					mostrarInfoTablas(seleccionTabla);
					
				}
			});
			areaInformacion = new JTextArea();
			
		add(areaInformacion, BorderLayout.CENTER);
		add(comboTablas, BorderLayout.NORTH);
		
		
	}
	
	public void conectarBBDD() {// conexion a la BBDD
		miConnection = null;
		String[] datos = new String[3];// para guardar lineas de texto en archivo
		try {

			entrada = new FileReader("C:\\Users\\Thomas Anderson\\Desktop\\accesoBBDDqq.txt");// FileReader para leer
																							// fichero con contraseña

		} catch (IOException e) {//***si NO se encuentra el archivo, salta catch para enseñar ventana y buscarlo

			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto", "txt");

			chooser.setFileFilter(filter);
			int returnVal = chooser.showOpenDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				try {
					entrada = new FileReader(chooser.getSelectedFile().getAbsolutePath());//se guarda en entrada el path del archivo
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

		try {
			BufferedReader miBufferedReader = new BufferedReader(entrada);//carga path
			for (int i = 0; i <= 2; i++) {
				datos[i] = miBufferedReader.readLine();// almacenar cada linea del texto en cada posición del array

			}

			miConnection = DriverManager.getConnection(datos[0], datos[1], datos[2]);//posiciones del array con datos de conexion
			entrada.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	
	public void obtenerTablas() {//para cargar las tablas al ejecutar ventana
		ResultSet miResultSet = null;
		
		try {
			DatabaseMetaData datosBBDD = miConnection.getMetaData();
				miResultSet = datosBBDD.getTables("pruebas_java", null, null, null);
				
			if (miResultSet.next() == false) {
				System.out.println("No hay nada");
			}else {
				do {
					comboTablas.addItem(miResultSet.getString("TABLE_NAME"));
					
				} while (miResultSet.next());
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void mostrarInfoTablas(String tabla) {
		
		ArrayList<String> campos = new ArrayList<>();
		String query = "SELECT * FROM "+ tabla;
		
		try {
			areaInformacion.setText("");
			
			Statement miStatement = miConnection.createStatement();
			ResultSet miResultSet = miStatement.executeQuery(query);
			ResultSetMetaData rsBBDD = miResultSet.getMetaData();//metadatos del RS, saber num de columnas y nombres
			
			for (int i = 1; i <= rsBBDD.getColumnCount(); i++) {//recorrerá las columnas de la tabla
				campos.add(rsBBDD.getColumnLabel(i));//'i' es las columnas
			}
			
			if (miResultSet.next() == false) {
				System.out.println("No trae nada");
			} else {
				do {
					for (String nombreCampo : campos) {
						areaInformacion.append(miResultSet.getString(nombreCampo) + " ");//agrega nombre columnas e información de cada campo
					}
					areaInformacion.append("\n");
				} while (miResultSet.next());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//private final String BBDD = "pruebas_java";
	private JComboBox comboTablas;
	private JTextArea areaInformacion;
	private Connection miConnection;
	//private final String url = "jdbc:mysql://localhost:3306/"+BBDD+"?serverTimezone=UTC&useSSL=false";
	private FileReader entrada;
	
	
}