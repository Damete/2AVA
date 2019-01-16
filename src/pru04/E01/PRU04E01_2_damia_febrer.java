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
			BufferedWriter bw = new BufferedWriter(new FileWriter(args[0] +"test"));
			ArrayList<String> paraules = new ArrayList<String>();
			String llegir_linea;
			String cast;
			String net;
			do {
				llegir_linea = br.readLine();
				if(llegir_linea != null) {
					paraules.add(llegir_linea);
				}
			}
			while(llegir_linea != null);
			for(int i=0; i < paraules.size(); i++) {
				cast = paraules.get(i);
				if(cast.contains(null)) {
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