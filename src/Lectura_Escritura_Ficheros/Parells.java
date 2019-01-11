package Lectura_Escritura_Ficheros;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Parells {
	public static void main(String[] args) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Damià Febrer\\Programacion\\parells.dat"));
			for (int i=0; i<=500; i+=2) {
				bw.write(i +"\n");
			}
			bw.close();
			System.out.println("S'ha escrtit correctament");
		}
		catch(IOException e){
			System.out.println("hi ha un error");
		}
	}
}
