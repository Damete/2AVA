package MySQL;

public abstract class Sonda {
	public boolean enregistarTemperatura(String IP, String Ubicacio, double valor);
	public double obtenerTemperatura(String Ubicacio, Date data);
}
