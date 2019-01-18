import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PRU04E02_damia_febrer {
	public static String trocejarCamp(String cadena, int posicion_inicial, int posicion_final ) {
		cadena = "";
		for (int i = posicion_inicial; i<posicion_final; i++ ) {
			if(cadena.charAt(i) != 32) {
				cadena += cadena.charAt(i);
			}
		}
		return cadena + ";";
	}
	public static void main (String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]));
			String emp_no,birth_date,first_name,last_name,gender,hire_date,leer;
			do {
				leer = br.readLine();
				emp_no = trocejarCamp(leer,1,6);
				birth_date = trocejarCamp(leer,7,16);
				first_name = trocejarCamp(leer,17,27);
				last_name = trocejarCamp(leer,28,41);
				gender = trocejarCamp(leer,42,48);
				hire_date = trocejarCamp(leer,49,58);
			}
			while(leer != null);
			br.close();
			bw.close();
		}
		catch(IOException e){
			System.out.println("Hi ha un error");
		}
	}
}