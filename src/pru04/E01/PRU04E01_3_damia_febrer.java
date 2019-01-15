package pru04.E01;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PRU04E01_3_damia_febrer {
	public static void main (String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			BufferedWriter bw = new BufferedWriter(new FileWriter(args[0] +"comptat"));
			/*Tenim un ArrayList a on ficarem el que es vagi llegint del fitxer*/
			ArrayList<String> paraules = new ArrayList<String>();
			String llegir_paraula;
			String cercar = args[1];
			int contador = 0;
			String enteroString = null;
			/*Mentres hi hagi text al fitxer es va afegint a la variable llegir_paraula y despres es fica a l'ArrayList*/
			do {
				llegir_paraula = br.readLine();
				if(llegir_paraula != null) {
					paraules.add(llegir_paraula);
				}
			}
			while(llegir_paraula != null);
			/*Es comproba si la paraula que s'ha ficat com a argument es igual a la que esta contenguda a la poscio de l'ArrayList indicada, si ho es susma 1 a la variable contador*/
			for(int i=0; i < paraules.size(); i++) {
				if(paraules.get(i).equals(cercar)) {
					contador ++;
				}
				enteroString = Integer.toString(contador);
			}
			bw.write("La paraula indicada apareix " + enteroString + " vegada/es");
			br.close();
			bw.close();
		}
		catch(IOException e) {
			System.out.println("Hi ha un error");
		}
	}
}
