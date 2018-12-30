package pru03.E06;
import java.util.Scanner;

public class PRU03E06_damia_febrer {
	Scanner sc = new Scanner(System.in);
	public class Zona{
		private int entradesPerVendre;
		public Zona(int n) {
			entradesPerVendre = n;
		}
		public int entradesPerVendre() {
			return entradesPerVendre;
		}
		public void vendre(int n) {
			if (this.entradesPerVendre == 0) {
				System.out.println("Ho sentim, les entrades per la zona" + "triada estan exhaurides.");
			}
			else if (this.entradesPerVendre < n) {
				System.out.println("Nomes queden " + this.entradesPerVendre + " entrades per aquesta zona.");
			}
			if (this.entradesPerVendre >= n) {
				entradesPerVendre -= n;
				System.out.println("Aquí té les seves " + n + " entrades, gràcies.");
			}
		}
	}
	// Aqui generam les distintes zones y assignam el número d'entrades que tendrá cada zona.
	Zona platea = new Zona(1000);
	Zona amfiteatre = new Zona(200);
	Zona VIP = new Zona(25);

	public void menu() {
		int menu_principal;
		int menu_secundari;
		int entrades;
		do {
			System.out.println("\n" + "1. Mostrar número d'entrades lliures" + "\n" + "2. Vendre entrades" + "\n" + "3. Sortir" + "\n");
			menu_principal = sc.nextInt();
			//Aquesta es la primera opció del menu la qual ens deixa triar la zona de la que volem saber les entrades disponibles i hen ho mostra
			if (menu_principal == 1) {
				do {
					System.out.println("\n" + "1. Platea" + "\n" + "2. Amfiteatre" + "\n" + "3. VIP" + "\n" + "4. Tornar al menu principal" + "\n");
					menu_secundari = sc.nextInt();
					switch(menu_secundari) {
					case 1:
						System.out.println(platea.entradesPerVendre + " Entrades lliures." + "\n");
						break;
					case 2:
						System.out.println(amfiteatre.entradesPerVendre + " Entrades lliures." + "\n");
						break;
					case 3:
						System.out.println(VIP.entradesPerVendre + " Entrades lliures." + "\n");
						break;
					}
				}
				while(menu_secundari!=4);
			}
			if (menu_principal == 2) {
				// La segona opció del menu ens permet comprar entrades per a la zona que seleccionem, aixo ho fa cridant al mètode vendre que prèviament s'ha definit per la clase Zona y ho seguira fent mentres l'usuari no surti del bucle
				do {
					System.out.println("\n" + "Seleccioni la zona de la que vol comprar entrades." + "\n" + "1. Platea" + "\n" + "2. Amfiteatre" + "\n" + "3. VIP" + "\n" + "4. Tornar al menu principal");
					menu_secundari = sc.nextInt();
					switch(menu_secundari) {
					case 1:
						System.out.println("\n" + "Quantes entrades vol?" + "\n");
						entrades = sc.nextInt();
						platea.vendre(entrades);
						break;
					case 2:
						System.out.println("\n" + "Quantes entrades vol?" + "\n");
						entrades = sc.nextInt();
						amfiteatre.vendre(entrades);
						break;
					case 3:
						System.out.println("\n" + "Quantes entrades vol?" + "\n");
						entrades = sc.nextInt();
						VIP.vendre(entrades);
						break;
					}
				}
				while(menu_secundari!=4);
			}

		}

		while(menu_principal!=3);
		return ;
	}
	public static void main (String[] args) {
		PRU03E06_damia_febrer damo = new PRU03E06_damia_febrer();
		damo.menu();
	}
}