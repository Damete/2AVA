package Grafico;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Options {
	public static void main (String[] args) {
		JFrame main = new JFrame();
		/*Una array de strings que contiene las opciones que apareceran en la ventana*/
		Object[] options = {"SI", "NO", "SALIR"};
		/*El constructor de la ventana 1-El mensaje que saldra en el cuerpo de la ventana 2.El titulo de la ventana 3- El tipo de ventana 4-El tipo de mensaje
		 *  5-icono (si no queremos poner nada ponemos null) 6-La array de la que coje las opciones 7-La opcion que estará resaltada por defecto*/
		int n = JOptionPane.showOptionDialog(main, "Tu que dirias ?", "Opcional", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
	}
}
