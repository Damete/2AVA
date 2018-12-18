package pru03.E05;

public class PRU03E05Pizza_damia_febrer {

	public String mida;
	public String tipus;
	public enum estat{
		demanada,
		servida;
	}
	protected estat pipo;
	public static int pizzesDemanades=0;
	public static int pizzesServides=0;
	//En el constructor indicamos que cada vez que se solicita una pozza sumamos 1 a pizzas pedidas para de este modo poder llevar una cuenta de cuantas pizzas estan pedidas
	public PRU03E05Pizza_damia_febrer(String tipus, String mida) {
		this.mida=mida;
		this.tipus=tipus;
		this.pipo=estat.demanada;
		pizzesDemanades++;
	}
	// En el metodo sirve hacemos que las pizzas pasen de estar pedidas a servidas. Luego restamos 1 pizza de pedidas y la sumamos en servidas. Si la pizza ya esta pedida nos lo notifica. Y cunado servimos una pizza nos indica que la pizza solicitada esta servida
	public void sirve() {
		if (pipo.equals(estat.demanada)) {
			System.out.println("Pizza " + tipus + " " + mida + " servida");
			pipo=estat.servida;
			pizzesDemanades--;
			pizzesServides++;
		}
		else {
			System.out.println("Aquesta pizza ja esta servida");
		}

	}
	//Devuelde el estado de la pizza
	public estat comprobarEstat() {
		return pipo;

	}
	public static int getTotalDemanades() {
		return pizzesDemanades;
	}
	public static int getTotalSerivdes() {
		return pizzesServides;
	}
	//Sobreescribimos el metodo toString para que nos enseñe los obejetos del tipo pizza de la forma en que nos conviene
	@Override
	public String toString() {
		return "pizza " + tipus + " " + mida + " " + this.pipo;
	}
}
