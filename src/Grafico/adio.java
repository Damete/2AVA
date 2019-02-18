package Grafico;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class adio {
	public static void main (String[] args) {
		JFrame main = new JFrame("Gia BOOOOOI!!");
		JLabel texto = new JLabel();
		main.getContentPane().add(texto, BorderLayout.CENTER);
		main.pack();
		main.setVisible(true);
	}
}
