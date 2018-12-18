package pru03.E05;

public class PRU03E05PizzaTest_damia_febrer {

	public static void main (String[] args) {

		PRU03E05Pizza_damia_febrer p1 = new PRU03E05Pizza_damia_febrer("margarita","mitjana");
		PRU03E05Pizza_damia_febrer p2 = new PRU03E05Pizza_damia_febrer("funghi","familiar");
		p2.sirve();
		PRU03E05Pizza_damia_febrer p3 = new PRU03E05Pizza_damia_febrer("quatre formatges","mitjana");
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		p2.sirve();
		System.out.println(p1.comprobarEstat());
		System.out.println("Demanades " + PRU03E05Pizza_damia_febrer.getTotalDemanades());
		System.out.println("Servides " + PRU03E05Pizza_damia_febrer.getTotalSerivdes());
	}
}
