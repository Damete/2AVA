package Grafico;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class input {
	public static void main (String[] args) {
		Object[] posibilities = {"Pipo","!PIPO","Manolo"};
		JFrame main = new JFrame();
		String s = (String)JOptionPane.showInputDialog(main, "Que elejirias","Choose",JOptionPane.QUESTION_MESSAGE,null,posibilities,"Pipo");
		if((s != null)&& s.length()>0) {
			if(s.equals("!PIPO")) {
				System.out.println("Maldito traidor blasfemo");
			}
			else {
				System.out.println("Has elejido " + s);
			}
		}
		else {
			System.out.println("No has elejido nada");
		}
	}
}
