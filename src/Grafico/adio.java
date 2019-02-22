package Grafico;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class adio {
	public static void main (String[] args) {
		/*Creamos el frame en el que meteremos el mensaje*/
		JFrame main = new JFrame();
		/*Creamos el menssaje, para ello usamos el metodo showMessageDialog, dentro del parentesis le especificamos 1-El frame al que pertenece 2-El cuerpo del mensaje 3-El mensaje que sale en la parte superior de la ventana 4-El tipo de mensaje que se nos muestra*/
		JOptionPane.showMessageDialog(main, "INDEX OUT OF BOUNDS", "FATAL ERROR", JOptionPane.ERROR_MESSAGE);
	}
}
