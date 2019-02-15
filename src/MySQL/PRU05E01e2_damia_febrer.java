package MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class PRU05E01e2_damia_febrer {
	private Connection conexion = null; 
	private Statement statement = null;
	private ResultSet eliminar = null;
	private ResultSet resultado = null;
	Scanner sc = new Scanner(System.in);
	
	public void leerBase() throws SQLException {
		try {
			String cambio;
			String nombre = null;
			/*Conectarse con la base de datos*/
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/employees? user=root&password=cide1234");
			/*Crear el flujo de ordenes*/
			statement = conexion.createStatement();
			/*Enviar las ordenes a la base de datos*/
			resultado = statement.executeQuery("select * from departments order by dept_no DESC");
			obtenerInfo(resultado);
			System.out.println("De que departamento quieres acmbiar el nombre?");
			cambio = sc.nextLine();
			System.out.println("Introduce el nuevo nombre del departamento");
			nombre = sc.nextLine();
			eliminar = statement.executeQuery("update departments set dept_name = '" + nombre + "' where dept_name = '" + cambio +"'");
			resultado.close();
			statement.close();
			conexion.close();
		} catch (SQLException e) {
			conexion.close();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public void obtenerInfo(ResultSet resultSet) throws Exception{
		while(resultado.next()) {
			String dept_no = resultado.getString("dept_no");
			String dept_name = resultado.getString("dept_name");
			
			System.out.println("El nummero del departamento es: " + dept_no);
			System.out.println("El nombre del departamento es: " + dept_name);
			System.out.println("==================================");
		}
	}
	public static void main (String[] args) throws Exception{
		PRU05E01e2_damia_febrer base = new PRU05E01e2_damia_febrer();
		base.leerBase();
	}
}