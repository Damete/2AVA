package Grafico;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class imagen {
	public static void main(String[] args) {
		ImageIcon icon = new ImageIcon("F:\\Usuario 2\\SKT.png");
		JFrame main = new JFrame();
		/*Todo igual que en el anterior (adio.java) pero al final le pasamos la variable icon que es del tipo ImageIcon, esto nos mostrara la imagen a la que lleva la ruta que contiene la variable*/
		JOptionPane.showMessageDialog(main, "La mehor composision de la istoria", "SKT T1", JOptionPane.INFORMATION_MESSAGE, icon);
	}
}