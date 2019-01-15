package pru04.E01;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ArrayList;

public class PRU04E01_1_damia_febrer{
	public static void main (String[] args) {
		try {
			String comprovar_paraules;
			BufferedReader br = new BufferedReader(new FileReader (args[0]));
			BufferedWriter bw = new BufferedWriter(new FileWriter (args[0] + "sorted"));
			ArrayList<String> palabras = new ArrayList<String>();
			do {
				comprovar_paraules = br.readLine();
				palabras.add(comprovar_paraules);
			}
			while(comprovar_paraules != null);
			br.close();
			for(int i=0; i<palabras.size(); i++) {
				bw.write(palabras.get(i));
			}
			bw.close();
		}
		catch(IOException e){
			System.out.println("Hi ha un error");
		}
	}
}