package pru04.E02;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PRU04E02_damia_febrer {
	/*Aqui cream el metode que posara el ; a cada una de les diferents columnes.*/
	public static String trocejarCamp(String cadena, int posicion_inicial, int posicion_final ) {
		String modificat = "";
		/*Empram el charAt per navegar entre cada un dels caracters del String que li donam al metode*/
		for (int i = posicion_inicial; i<=posicion_final; i++ ) {
			if(cadena.charAt(i) != 32) {
				modificat += cadena.charAt(i);
			}
		}
		return modificat + ";";
	}
	public static void main (String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]));
			String emp_no,birth_date,first_name,last_name,gender,hire_date,leer;
			do {
				/*Empram una variable per llegir el fitxer y despres tenim una variable per a cada columan del fitxer, mitjançant la variable a on ficam el que es llegeix del document y dos integers indicam al metode a on comença y a on acaba la columna*/
				leer = br.readLine();
				if(leer != null) {
				emp_no = trocejarCamp(leer,0,5);
				birth_date = trocejarCamp(leer,6,15);
				first_name = trocejarCamp(leer,16,26);
				last_name = trocejarCamp(leer,27,40);
				gender = trocejarCamp(leer,41,47);
				hire_date = trocejarCamp(leer,48,57);
				/*Una vegada llegit i modificat o escrivim al nou fitxer afegint un bot de linea al final de cada linea*/
				bw.write(emp_no + birth_date + first_name + last_name + gender + hire_date + "\n");
				}
			}
			while(leer != null);
			br.close();
			bw.close();
		}
		catch(IOException e){
			System.out.println("Hi ha un error");
		}
	}
}