package pru04.E02;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PRU04E02_damia_febrer {
	public String trocejarCamp(String cadena, int posicion_inicial, int posicion_final ) {
		cadena = "";
		return cadena;
	}
	public static void main (String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]));
			String emp_no,birth_date,first_name,last_name,gender,hire_date,leer;
			do {
				leer = br.readLine();
				emp_no = br.readLine();
			}
			while(leer != null);
		}
		catch(IOException e){
			System.out.println("Hi ha un error");
		}
	}
}