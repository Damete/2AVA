package pru04.E01;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.ArrayList;

public class PRU04E01_1_damia_febrer{
	public static void main (String[] args) {
		try {
			String comprovar_paraules;
			BufferedReader br = new BufferedReader(new FileReader (args[0]));
			BufferedWriter bw = new BufferedWriter(new FileWriter (args[0] + "sorted.txt"));
			ArrayList<String> palabras = new ArrayList<String>();

			do {
				comprovar_paraules = br.readLine();
				if (comprovar_paraules!=null) {
					palabras.add(comprovar_paraules);
				}
				
			}
			while(comprovar_paraules != null);
			Collections.sort(palabras);
			for(int i=0; i<palabras.size(); i++) {
				bw.write(palabras.get(i) + "\n");
			}
			br.close();
			bw.close();
		}
		catch(IOException e){
			System.out.println("Hi ha un error");
		}
	}
}