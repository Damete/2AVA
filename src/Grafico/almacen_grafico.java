package Grafico;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*Esto se destina a modificar el ejercicio del almacen pasando el menú al entorno gráfico*/

public class almacen_grafico {
	public class kk2 {
		public static void main (String[] args) {
			JFrame main = new JFrame();
			Object[] opciones = {"1- Listado","2-Alta","3-Baja","4-Modificacion","5-Entrada de mercancias","6-Salida de mercancias","7-Salir"};
			int menu = 0;
			do {
				String eleccion = (String)JOptionPane.showInputDialog(main, "Que prefieres?", "Choose", JOptionPane.PLAIN_MESSAGE, null, opciones, "PIPO");
				if((eleccion !=null)&& eleccion.length()>0) {
					if(eleccion.equals("7-Salir")) {
						menu = 7;
					}
					if(eleccion.equals("1-Listado")) {
						
					}
				}
			}
			while(menu != 7);
		}
	}
}
