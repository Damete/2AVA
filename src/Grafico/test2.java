package Grafico;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class test2 {
	public static void main (String[] args) {
		Object[] posibilities = {"Pipo","!PIPO","Manolo"};
		Object[] posibilidades = {"Pipo", "Tofol", "Manue"};
		ImageIcon icon = new ImageIcon("C:\\Users\\alumne-DAM.EQUIPOSMX\\Desktop\\capo.jpg");
		JFrame main = new JFrame();
		String s = (String)JOptionPane.showInputDialog(main, "Que elejirias","Choose",JOptionPane.QUESTION_MESSAGE,null,posibilities,"Pipo");
		if((s != null)&& s.length()>0) {
			if(s.equals("!PIPO")) {
				JOptionPane.showMessageDialog(main, "Blasfemia", "No podés",JOptionPane.ERROR_MESSAGE,icon);
			}
			else {
				JOptionPane.showMessageDialog(main, "Has elejido " + s , "Tu eleccion", JOptionPane.PLAIN_MESSAGE);
			}
		}
		else {
			String nuevo = (String)JOptionPane.showInputDialog(main, "Elije con cuidado", "Esta vez hazlo bien",JOptionPane.ERROR_MESSAGE,null,posibilidades,"Pipo");
			if(nuevo.equals("Pipo")) {
				JOptionPane.showMessageDialog(main, "Has elegido bien", "Good boi", JOptionPane.PLAIN_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(main, "Mal", "Pipo llora",JOptionPane.ERROR_MESSAGE,icon);
			}
		}
	}
}