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
	private ResultSet resultado = null;

	Scanner sc = new Scanner(System.in);

	public void leerBase(String argumento) throws SQLException {
		try {
			String nombre = null;
			/*Conectarse con la base de datos*/
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/employees?user=root&password=cide1234");
			/*Crear el flujo de ordenes*/
			statement = conexion.createStatement();
			/*Obtenemos el resultado de la consulta*/
			resultado = statement.executeQuery("select * from departments order by dept_no DESC");
			/*Mostramos el resultado de la consulta*/
			obtenerInfo(resultado);
			statement.execute("delete from departments where dept_name = '" + argumento + "'");
			System.out.println("Introduce el nuevo nombre del departamento");
			nombre = sc.nextLine();
			/*Modificamos el departamento que se pasa como argumento con el nombre que solicitamos al usuario*/
			statement.execute("insert into departments (dept_no,dept_name) values ('" + argumento + "','" + nombre + "'");
			/*Volvemos a obtener el resultado de la consulta*/
			resultado = statement.executeQuery("select * from departments order by dept_no DESC");
			/*Y volvemos a mostrarlo ahora modificado*/
			obtenerInfo(resultado);
			/*Cerramos las coneciones*/
			resultado.close();
			statement.close();
			conexion.close();
		} catch (SQLException e) {
			e.getMessage();
			conexion.close();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public void obtenerInfo(ResultSet resultado) throws Exception{
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
		base.leerBase(args[0]);
	}
}