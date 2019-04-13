package MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class SondaTemperatura extends Sonda{
	Connection conexion = null;
	Statement statement = null;
	ResultSet resultado = null;

	public void leerBD() throws SQLException{
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://195.77.81.43:44004/Temperatures?user=alumne&password=tofol");
			statement = conexion.createStatement();
			resultado = statement.executeQuery("select Ubicacio, data from Temperatures");
			presentar(resultado);
			salir();
		}
		catch(SQLException e) {
			e.getMessage();
			conexion.close();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void presentar(ResultSet resultSet) throws SQLException{
		try {
			while(resultSet.next()) {
				String ubicacion = resultSet.getString("Ubicacio");
				String fecha = resultSet.getString("data");
				String valor = resultSet.getString("valor");

				System.out.println(ubicacion);
				System.out.println(fecha);
				System.out.println(valor);
				System.out.println("===================================");
			}
		}
		catch(SQLException e) {
			e.getMessage();
		}
	}

	public void salir() throws Exception{
		try{
			conexion.close();
			statement.close();
			resultado.close();
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
	
	@Override
	public double obtenerTemperatura(String Ubicacio, Date data){
		try {
			leerBD();
		}
		catch(Exception e) {
			e.getMessage();
		}
		return 0;
	}

	public static void main(String[] args) throws SQLException {
		SondaTemperatura sonda = new SondaTemperatura();
		sonda.leerBD();
	}
}