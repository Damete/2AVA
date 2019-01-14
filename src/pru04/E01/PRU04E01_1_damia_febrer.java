package pru04.E01;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ArrayList;

public class PRU04E01_1_damia_febrer {
	public static void main (String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader (args[0]));
			BufferedWriter bw = new BufferedWriter(new FileWriter (args[0]+"_sorted.txt"));
			ArrayList<String> palabras = new ArrayList<String>();
			for(int i=1; i<args[0].length(); i++) {
				palabras.add(br.readLine());
			}
			Collections.sort(palabras);
			System.out.println(palabras);
			br.close();
			bw.close();
		}
		catch(IOException e){
			System.out.println("Hi ha un error");
		}
	}
}