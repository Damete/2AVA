package Lectura_Escritura_Ficheros;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Tots {
	public static void main(String[] args) {
		try {
			BufferedReader brs = new BufferedReader(new FileReader("F:\\DAM\\senars.dat"));
			BufferedReader brp = new BufferedReader(new FileReader("F:\\DAM\\parells.dat"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("F:\\DAM\\tots.dat"));
			String senars = "";
			String parells = "";

			while (senars != null && parells != null){
				if(parells!=null){
					parells = brp.readLine();
					bw.write(parells + "\n");
				}
				if(senars!=null) {
					senars = brs.readLine();
					bw.write(senars + "\n");
				}
			}
			brs.close();
			brp.close();
			bw.close();
			System.out.println("S'ha escrtit correctament");
		}
		catch(IOException e){
			System.out.println("Hi ha un error");
		}
	}
}
