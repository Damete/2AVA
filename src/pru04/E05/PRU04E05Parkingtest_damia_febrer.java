package pru04.E05;

import java.util.HashMap;
import java.util.Scanner;

public class PRU04E05Parkingtest_damia_febrer {
	public String comprovarMatricula(String intro) {
		System.out.println("Introduce matricula");
		Scanner sc = new Scanner(System.in);
		String inicial;
		String matricula="";
		inicial=sc.nextLine();
		try {
			for(int i=0; i<4; i++) {
				if(inicial.charAt(i)>=48 && inicial.charAt(i)<=57) {
					matricula+=inicial.charAt(i);
				}
			}
			System.out.println(matricula);
			for(int i=4; i<7; i++) {
				if(inicial.charAt(i)>=65 && inicial.charAt(i)<=90) {
					matricula+=inicial.charAt(i);
				}
			}
			System.out.println(matricula);		}
		catch(Exception e) {
			System.out.println("La matricula introducida es incorrecta");
		}
		return matricula;
	}
	
	HashMap<Integer, String> mapa = new HashMap<Integer, String>();
	public int entraCoche(String matricula) {
		// Esta matricula puede usar el metodo comprovarMatricula
		mapa.put(2,matricula);
	}
}
