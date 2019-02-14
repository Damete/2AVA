package MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PRU05E01e1_damia_febrer {
	private Connection conexion = null; 
	private Statement statement = null;
	private ResultSet resultado = null;

	public void leerBase() throws SQLException {
		try {
			/*Conectarse con la base de datos*/
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/employees? user=root&password=cide1234");
			/*Crear el flujo de ordenes*/
			statement = conexion.createStatement();
			/*Enviar las ordenes a la base de datos*/
			resultado = statement.executeQuery("select * from departments order by dept_no DESC");
			obtenerInfo(resultado);
			/*Cerramos las conexiones*/
			resultado.close();
			statement.close();
			conexion.close();
		} catch (SQLException e) {
			conexion.close();
		} catch (Exception e) {
			System.out.println("Patata");
		}
	}
	public void obtenerInfo(ResultSet resultSet) throws Exception{
		while(resultado.next()) {
			/*Asignamos el valor de la columna dept_no a la variable dept_no*/
			String dept_no = resultado.getString("dept_no");
			/*Asignamos el valor de la columna dept_name a la variable dept_name*/
			String dept_name = resultado.getString("dept_name");

			System.out.println("El nummero del departamento es: " + dept_no);
			System.out.println("El nombre del departamento es: " + dept_name);
			System.out.println("==================================");
		}
	}
	public static void main(String[] args) throws Exception{
		PRU05E01e1_damia_febrer base = new PRU05E01e1_damia_febrer();
		base.leerBase();
	}
}