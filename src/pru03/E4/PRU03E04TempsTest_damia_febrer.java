package pru03.E4;

import java.util.Scanner;

public class PRU03E04TempsTest_damia_febrer {

	Scanner sc = new Scanner(System.in)
			;
	public PRU03E04TempsTest_damia_febrer(int hores, int minuts, int segons) {
		this.hores=hores;
		this.minuts=minuts;
		this.segons=segons;
	}

	int temps;
	int hores;
	int minuts;
	int segons;

	public sumar() {
		int ctrl=1;
		do {
			System.out.println("Introdueix una hora en format H-M-S");
			if (segons>60) {
				minuts=minuts+1;
			}
			if (minuts>60) {
				hores=hores+1;
			}
			ctrl=ctrl+1;
		}
		//Aqui vendria el to string para dejarlo en formato xHxMxS???? temps = hores+minuts+segons;
		while(ctrl!=2);
		return temps;
	}

	public restar() {

	}

	public static void main(String[] args) {
		PRU03E04TempsTest_damia_febrer t = new PRU03E04TempsTest_damia_febrer(1,20,30);
		t.sumar();
	}
}