package Grafico;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class testtext implements ActionListener{
	private static JTextField textField;
	public void frame() {
		/*Definicion del frame*/
		JFrame main = new JFrame("Ventana");
		/*Definir tamaño del frame*/
		main.setSize(100,150);
		/*Hacer que no se pueda modificar el tamaño*/
		main.setResizable(false);
		/*La accion predeterminada al cerrar*/
		main.setDefaultCloseOperation(main.EXIT_ON_CLOSE);
		/*Definir tamaño del textfield*/
		textField = new JTextField(20);
		/*Añadirle el action listener para que haga la accion al pulsar intro*/
		textField.addActionListener(this);
		/*añadimos el texfield al frame*/
		main.add(textField);
		/*Hacemos visible el frame*/
		main.setVisible(true);
	}
	
	public Component frame_aux() {
		/*Un frame para el option pane para sacar el resultado, (no necesario)*/
		JFrame secundario = new JFrame();
		return secundario;
	}

	public static void main(String[] args) {
		testtext a = new testtext();
		a.frame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*La string en la que meteremos el texto que se lea en el textfield*/
		String kk = textField.getText();
		JOptionPane.showMessageDialog(frame_aux(), "Has escrito: " + kk, "Test", JOptionPane.PLAIN_MESSAGE);
	}
}
