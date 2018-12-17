package pru03.E4;

public class PRU03E04TempsTest_damia_febrer {

	public static void main(String[] args) {
		PRU03E04Temps_damia_febrer t = new PRU03E04Temps_damia_febrer(1,20,30);
		PRU03E04Temps_damia_febrer t2 = new PRU03E04Temps_damia_febrer(1,10,40);
		System.out.println(t.restar(t2.hores, t2.minuts, t2.segons));
		System.out.println(t.toString());
	}
}