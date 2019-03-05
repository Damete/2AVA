package MySQL;

import java.util.Date;

public abstract class Sonda {
	public boolean enregistarTemperatura(String IP, String Ubicacio, double valor) {
		return false;
	}
	public double obtenerTemperatura(String Ubicacio, Date data) {
		return 0;
	}
}