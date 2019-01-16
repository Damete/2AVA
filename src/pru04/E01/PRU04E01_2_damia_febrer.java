package pru04.E01;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class PRU04E01_2_damia_febrer {
	public static void main (String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]));
			ArrayList<String> paraules = new ArrayList<String>();
			String llegir_linea;
			String comprovar;
			String net;
			/*Ficam el que es va llegint del fitxer a l'ArrayList si el que es troba esta bui deixa de ficar contigut a l'arraylist*/
			do {
				llegir_linea = br.readLine();
				if(llegir_linea != null) {
					paraules.add(llegir_linea);
				}
			}
			while(llegir_linea != null);
			/*Aqui treim el contingut de l'array y comproban si conte una doble barra. Si ho fa s'elimina aquesta posicio de l'array. Si no l'escriu al fitxer*/
			for(int i=0; i < paraules.size(); i++) {
				comprovar = paraules.get(i);
				if(comprovar.contains("//")) {
					paraules.remove(i);
				}
				net = paraules.get(i);
				bw.write(net + "\n");
			}
			br.close();
			bw.close();
		}
		catch(IOException e) {
			System.out.println("Hi ha un error");
		}
	}
}