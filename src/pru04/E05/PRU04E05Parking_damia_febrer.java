package pru04.E05;

import java.util.HashMap;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class PRU04E05Parking_damia_febrer {

	HashMap<Integer, String> mapa = new HashMap<Integer, String>();
	private int places_no_discapacitats;
	private int places_discapacitats;

	public enum TipusPlacesParking {
		discapacitada,
		no_discapacitat,
	}

	public PRU04E05Parking_damia_febrer(int places_no_discapacitats,int places_discapacitats) {
		this.places_no_discapacitats = places_no_discapacitats;
		this.places_discapacitats = places_discapacitats;
	}

	public void llegirMatricules(String path) throws Exception{
		String leido = path;
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			do {
				leido = br.readLine();
				if(leido != null) {
					entraCotxe(leido);
				}
			}
			while(leido != null);
			br.close();
		} catch ( FileNotFoundException e) {
			System.out.println("Fitxer incorrecte o inexistent.");
			Scanner sc = new Scanner(System.in);
			Scanner camino = new Scanner(System.in);
			String option;
			String ruta;
			System.out.println("Vols tornar a introduir la matricula??? \n S/N");
			option = sc.nextLine();
			if(option.equals("S")) {
				System.out.println("Introduceix la nova ruta");
				ruta = camino.nextLine();
				BufferedReader brr = new BufferedReader(new FileReader(ruta));
				String cogido;
				do {
					cogido = brr.readLine();
					if(cogido != null) {
						entraCotxe(cogido);
					}
				}
				while(cogido != null);
				brr.close();
			}
			if(option.equals("N")){
				System.out.println("ok :(");
			}
		}
	}

	public int entraCotxe(String matricula) throws Exception{
		/*Aignamos el ID a la matricula con respecot a las plazas libres que tenemos */
		String leido = matricula;
		boolean valid;
		int places_lliures = getPlacesLliures(TipusPlacesParking.no_discapacitat);
		int Identificador = places_no_discapacitats - places_lliures;
		valid = comprovarMatricula(leido);
		try {
			if(85*places_no_discapacitats/100 <= getPlacesOcupades(TipusPlacesParking.no_discapacitat)){
				System.out.println("Ocupació de places per no discapacitats supera el 85%.");
			}
			if(places_no_discapacitats != 0) {
				if(valid == true) {
					int garrulo = (int)(Math.random()*100);
					if(garrulo >=95) {
						mapa.put(getPlacesLliures(TipusPlacesParking.discapacitada), leido);
						System.out.println("ALERTA =====> Garrulo detected!!! Ha aparcat a la plaça:" + getPlacesLliures(TipusPlacesParking.discapacitada));
					}
					mapa.put(Identificador,leido);
				}
				else {
					System.out.println("Vols tornar a introduir la matriucla? \n");
				}
			}	
		}
		catch(Exception e) {
			System.out.println("El parking esta ple");
		}
		return places_no_discapacitats;
	}

	public int entraCotxeDiscapacitat(String matricula) throws Exception{
		/*Pera darle un identificador al coche cogemos la places libres y se lo asignamos a la variable Identificador. Luego comprobamos siq uedan places libres, si quedan lo asignamos si no, comprobamos si quedan plazas normales libres si no el parking esta lleno*/
		String leido = matricula;
		boolean valid;
		boolean ple = true;
		int Identificador = getPlacesLliures(TipusPlacesParking.discapacitada) + 100;
		valid = comprovarMatricula(leido);
		try {
			if(85*places_no_discapacitats/100 <= getPlacesOcupades(TipusPlacesParking.discapacitada)){
				System.out.println("Ocupació de places per discapacitats supera el 85%.");
			}
			if(places_discapacitats != 0) {
				if(valid == true) {
					mapa.put(Identificador,leido);
					ple = false;
				}
			}
		}
		catch(Exception e) {
		}
		try {
			if(ple && places_no_discapacitats != 0) {
				if(valid == true) {
					mapa.put(Identificador,leido);
					for(int i=105 ; i>0; i--) {
						System.out.println(mapa.get(i));
					}
				}
			}
			else {
				System.out.println("El parking esta ple");
			}
		}
		catch(Exception e) {
			System.out.println("El parking esta ple");
		}
		return places_discapacitats;
	}

	public void surtCotxe(String matricula) throws Exception{
		/*Comprobamos si la matricula que se le pasa al metodo esta en el mapa, si lo esta la eliminamos, si no indicamos que el coche no esta en el parking*/
		String leido = matricula;
		try {
			for (int i = 1; i<= getPlacesOcupades(TipusPlacesParking.no_discapacitat); i++) {
				if(mapa.get(i).equals(leido)) {
					mapa.remove(i);
				}
				else {
					System.out.println("El cotxe no és al parking.");
				}
			}
		}
		catch(Exception e) {
			System.out.println("El cotxe no és al parking.");
		}
	}

	public void surtCotxeDiscapacitat(String matricula) throws Exception{
		/*Lo mismo que en el anterior*/
		String leido = matricula;
		try {
			for(int i = 1; i> 105 ; i++) {
				if(mapa.get(i).equals(leido)) {
					mapa.remove(i);
				}
				else {
					System.out.println("El cotxe no és al parking.");
				}
			}
		}
		catch(Exception e) {
			System.out.println("El cotxe no és al parking.");
		}
	}

	public int getPlacesOcupades(TipusPlacesParking tipus) {
		/*Obtenemos el numero de plazas que estan ocupadas revisando el mapa, cada vez que nos encontramos con una posicion que contiene información nos indica que esa plaza esta ocupada*/
		int places = 0;
		String check = "";
		if(tipus.equals(TipusPlacesParking.no_discapacitat)) {
			for(int i=1; i<100; i++) {
				check = mapa.get(i);
				if(check != null) {
					places++;
				}
			}
		}
		if (tipus.equals(TipusPlacesParking.discapacitada)) {
			for(int i=101; i<=105; i++) {
				check = mapa.get(i);
				if(check != null) {
					places++;
				}
			}
		}
		return places;
	}

	public int getPlacesLliures(TipusPlacesParking tipus) {
		/*Comprobamos las posiciones del mapa, si nos devuelve un null significa que la posicion esta libre*/
		int places = 0;
		String check = "";
		if(tipus.equals(TipusPlacesParking.no_discapacitat)) {
			for(int i=1; i<100; i++) {
				check = mapa.get(i);
				if(check == null) {
					places++;
				}
			}
		}
		if(tipus.equals(TipusPlacesParking.discapacitada)) {
			for(int i=100; i<105; i++) {
				check = mapa.get(i);
				if(check == null) {
					places++;
				}
			}
		}
		return places;
	}

	public void guardarMatricules(String path) throws Exception{
		/*A traves de la ruta que nos proporcionan en el menu principal se le asigna el valor a la variable y se le pasa como argumento al filewriter*/
		try {
			String leido = "";
			BufferedWriter bw = new BufferedWriter(new FileWriter(path));
			for(int i = 1; i< mapa.size(); i++) {
				bw.write(leido = mapa.get(i));
				bw.newLine();
			}
			bw.close();
		}
		catch(Exception e) {
			System.out.println("Fitxer incorrecte o inexistent");
			Scanner sc = new Scanner(System.in);
			String option;
			String ruta;
			String texto ="";
			System.out.println("Vols tornar a introduir la ruta?? \n S/N");
			option = sc.nextLine();
			if(option.equals("S")) {
				System.out.println("Introdueix la nova ruta");
				ruta = sc.nextLine();
				BufferedWriter bww = new BufferedWriter(new FileWriter(ruta));
				for(int d = 1; d< mapa.size(); d++) {
					bww.write(texto = mapa.get(d));
					bww.newLine();
				}
				bww.close();
			}
			if(option.equals("N")) {
				System.out.println(":(");
			}
		}
	}

	private boolean comprovarMatricula(String matricula) {
		/*En este metodo comprobamos si la matricula esta conformada por 4 numeros y 3 letras mediante la utilizacion de 2 arrays y el charAt para comprobar si los valores que se leen son los adecuados mediante la conversion al codigo ASCII*/
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
				else {
					throw new NumberFormatException("");
				}
				comprovar = true;
			}
		}
		catch(Exception e) {
			System.out.println("Matricula Incorrecte");
			comprovar = false;
		}
		return comprovar;
	}
}
