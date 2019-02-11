package pru04.E05;

import java.util.HashMap;
import java.util.Scanner;

public class Pruebas {

	public static int places_no_discap = 100;
	public static int places_restar = places_no_discap;

	static HashMap<Integer, String> mapa = new HashMap<Integer, String>();

	public static boolean comprovarMatricula(String matricula) {
		int[] matricula_numeros = new int[4];
		char[] matricula_letras = new char[3];
		boolean comprovar = true;
		int posicion = 0;
		try {
			for(int i=0; i<matricula_numeros.length; i++) {
				if(matricula.charAt(i) >= 60 && matricula.charAt(i) <=71) {
					String test = "";
					test+=matricula.charAt(i);
					matricula_numeros[i] =  Integer.parseInt(test);
				}
			}
			for(int i=matricula_numeros.length; i<matricula.length() ; i++) {
				if(matricula.charAt(i)>=65 && matricula.charAt(i)<=90) {
					matricula_letras[posicion] = matricula.charAt(i);
					posicion++;
				}
			}
		}
		catch(Exception e) {
			System.out.println("Matricula Incorrecte");
			comprovar = false;
		}
		return comprovar;
	}

	public static  String entraCoche(String matricula) {
		String leido = matricula;
		boolean kk;
		int Identificador = places_restar;
		kk = comprovarMatricula(leido);
		if(kk == true) {
			mapa.put(Identificador,leido);
			for(int i=100 ; i>98; i--) {
				System.out.println(mapa.get(i));
			}
		}
		places_restar--;
		return leido;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Scanner er = new Scanner(System.in);
		Scanner ma = new Scanner(System.in);
		String test;
		int numero;
		int menu=0;
		do {
			System.out.println("La opcion del menu bro \n 1 algo \n 2 Salir");
			menu = sc.nextInt();
			if(menu==1) {
				System.out.println("Introduce matricula");
				test = er.nextLine();
				entraCoche(test);
				System.out.println(mapa.size());
			}
		}
		while (menu != 2);
	}
}
