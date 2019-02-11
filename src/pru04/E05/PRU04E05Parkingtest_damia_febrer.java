package pru04.E05;

import java.util.Scanner;


public class PRU04E05Parkingtest_damia_febrer {
	public static void main(String[] args) {
		PRU04E05Parking_damia_febrer Parking = new PRU04E05Parking_damia_febrer(100,5);
		Scanner sc = new Scanner(System.in);
		Scanner numero = new Scanner(System.in);
		Scanner surt_normal = new Scanner(System.in);
		Scanner surt_discap = new Scanner(System.in);
		int menu_principal=0;
		do {
			System.out.println("Super menú del aberno \n 1- Llenar parking \n 2- Entra coche \n 3- Entra coche discap \n 4- Sale coche \n 5- Sale coche discap \n 6- Guardar parking \n 7- Salir");
			menu_principal = sc. nextInt();
			if(menu_principal == 1) {
				try {
					Parking.llegirMatricules(args[0]);
				} catch (Exception e) {
					System.out.println(e);
				}
			}

			if(menu_principal == 2) {
				String matricula;
				System.out.println("Introduce la matriucla");
				matricula = numero.nextLine();
				try {
					Parking.entraCotxe(matricula);
				} catch (Exception e) {
					System.out.println("Matricula Incorrecte");
				}
			}

			if(menu_principal == 3) {
				String matricula;
				System.out.println("Introduce la matriucla");
				matricula = numero.nextLine();
				try {
					Parking.entraCotxeDiscapacitat(matricula);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if(menu_principal == 4) {
				String matricula;
				System.out.println("Quina es la matricula del cotxe que parteix ?");
				matricula = surt_normal.nextLine();
				try {
					Parking.surtCotxe(matricula);
				}
				catch(Exception e){
					System.out.println("Hi ha un error");
				}
			}

			if(menu_principal == 5) {
				String matricula;
				System.out.println("Quina es la matricula del cotxe que parteix ?");
				matricula = surt_discap.nextLine();
				try {
					Parking.surtCotxeDiscapacitat(matricula);
				}
				catch(Exception e) {
					System.out.println("PETADA");
				}
			}

			if(menu_principal == 6) {
				try {
					Parking.guardarMatricules(args[1]);
				} catch (Exception e) {
					System.out.println("No es troba el fitxer");
				}
			}
		}
		while(menu_principal != 7);
	}
}
