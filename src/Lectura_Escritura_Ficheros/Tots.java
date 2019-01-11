package Lectura_Escritura_Ficheros;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Tots {
	public static void main(String[] args) {
		try {
			BufferedReader brs = new BufferedReader(new FileReader("C:\\Damià Febrer\\Programacion\\senars.dat"));
			BufferedReader brp = new BufferedReader(new FileReader("C:\\Damià Febrer\\Programacion\\parells.dat"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Damià Febrer\\Programacion\\tots.dat"));
			String senars = "";
			String parells = "";
			
			while (senars != null && parells != null){
				senars = brs.readLine();
				parells = brp.readLine();
			}
			brs.close();
			bw.close();
			System.out.println("S'ha escrtit correctament");
		}
		catch(IOException e){
			System.out.println("Hi ha un error");
		}
	}
}
