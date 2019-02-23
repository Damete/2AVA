package Grafico;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*Esto se destina a modificar el ejercicio del almacen pasando el menú al entorno gráfico*/

public class almacen_grafico {

	public class Article {
		private String codi = "LLIURE";
		private String descripcio;
		private double preuDeCompra;
		private double preuDeVenda;
		private int stock;

		public String getCodi() {
			return codi;
		}

		public void setCodi(String codi) {
			this.codi = codi;
		}

		public String getDescripcio() {
			return descripcio;
		}

		public void setDescripcio(String descripcio) {
			this.descripcio = descripcio;
		}

		public double getPreuDeCompra() {
			return preuDeCompra;
		}

		public void setPreuDeCompra(double preuDeCompra) {
			this.preuDeCompra = preuDeCompra;
		}

		public double getPreuDeVenda() {
			return preuDeVenda;
		}

		public void setPreuDeVenda(double preuDeVenda) {
			this.preuDeVenda = preuDeVenda;
		}

		public int getStock() {
			return stock;
		}

		public void setStock(int stock) {
			this.stock = stock;
		}

		public String toString() {
			String cadena = "-------------------------------";
			cadena += "\nCodi: " + this.codi;
			cadena += "\nDescripcio: " + this.descripcio;
			cadena += "\nPreu de Compra: " + this.preuDeCompra;
			cadena += "\nPreu de Venda: " + this.preuDeVenda;
			cadena += "\nStock: " + this.stock + " unitats";
			cadena += "\n-------------------------------";
			return cadena;
		}
	}

	Scanner sc = new Scanner(System.in);
	ArrayList<Article> articles = new ArrayList<Article>();
	int menu_secundari = 0;
	int check;
	String codi;
	String descripcio;
	double preuDeCompra = 0.0;
	double preuDeVenda = 0.0;
	int stock = 0;
	int eliminar;
	int entrada;
	int valor_a_modificar;
	int quantitat = 0;
	String modificar_codi;
	String comprobar_codigo;
	String modificacio="0";
	double modificar_preu;
	double preu_a_modificar;
	double comprovar_preu;

	public String frame() {
		JFrame main = new JFrame();
		Object[] opciones = {"1-Listado","2-Alta","3-Baja","4-Modificacion","5-Entrada","6-Salida","7-Salir"};
		String principal = (String)JOptionPane.showInputDialog(main,"Que operacion quieres realizar?","Main",JOptionPane.PLAIN_MESSAGE,null,opciones,"1-Listado");
		if(principal.equals("1-Listado")) {
			listado();
		}
		if(principal.equals("2-Alta")) {
			alta();
		}
		if(principal.equals("3-Baja")) {
			baja();
		}
		if(principal.equals("4-Modificacion")) {
			modificacion();
		}
		if(principal.equals("5-Entrada")) {
			entrada();
		}
		if(principal.equals("6-Salida")) {
			salida();
		}
		main.setDefaultCloseOperation(main.EXIT_ON_CLOSE);
		return principal;
	}

	public Component frame_aux() {
		JFrame aux = new JFrame();
		return aux;
	}

	public void listado() {
		Article test = null;
		for (int i=0; i < articles.size(); i++) {
			test = articles.get(i);
			JOptionPane.showMessageDialog(frame_aux(),test,"Listado",JOptionPane.PLAIN_MESSAGE);
		}
		if(articles.size() <= 0) {
			JOptionPane.showMessageDialog(frame_aux(), "No hay ningun articulo en el almacen", "Error", JOptionPane.ERROR_MESSAGE,null);
		}
	}

	public void alta() {
		System.out.println("\n Introdueixi el codi de l'article \n");
		codi = sc.next();
		System.out.println("\n Introdueixi la descripcio de l'article \n");
		descripcio = sc.next();
		do {
			System.out.println("\n Intordueixi el preu de compra de l'article \n");
			comprovar_preu = sc.nextDouble();
			if(comprovar_preu < 0) {	//Comprobam que el valor que asignam al preu no sigui negatiu
				JOptionPane.showMessageDialog(frame_aux(),"No puedes asignar un valor negativo, por favor vuelve a introducirlo" , "Error", JOptionPane.ERROR_MESSAGE);
			}
			if(comprovar_preu >= 0) {
				preuDeCompra = comprovar_preu;
			}
		}
		while(comprovar_preu < 0);
		do {
			System.out.println("\n Introdueixi el preu de venda de l'article \n");
			comprovar_preu = sc.nextDouble();
			if(comprovar_preu < 0) {	//Comprobam que el valor que asignam al preu no sigui negatiu
				JOptionPane.showMessageDialog(frame_aux(),"No puedes asignar un valor negativo, por favor vuelve a introducirlo" , "Error", JOptionPane.ERROR_MESSAGE);
			}
			if(comprovar_preu >= 0) {
				preuDeVenda = comprovar_preu;
			}
		}
		while(comprovar_preu < 0);
		do {
			System.out.println("\n Intordueixi el stock de l'article \n");
			check = sc.nextInt();
			if (check < 0) {	//Comprobam que el valor que asignam a l'estock no sigui negatiu
				JOptionPane.showMessageDialog(frame_aux(),"No puedes asignar un valor negativo, por favor vuelve a introducirlo" , "Error", JOptionPane.ERROR_MESSAGE);
			}
			if (check >= 0) {
				stock = check;
			}
		}
		while(check <0);
		Article pipo = new Article();
		pipo.setCodi(codi);
		pipo.setDescripcio(descripcio);
		pipo.setPreuDeCompra(preuDeCompra);
		pipo.setPreuDeVenda(preuDeVenda);
		pipo.setStock(stock);
		System.out.println(pipo.toString());
		JOptionPane.showMessageDialog(frame_aux(), "Articulo añadido correctamente", "Alta", JOptionPane.PLAIN_MESSAGE);
		articles.add(pipo);
	}

	public void baja() {
		if(articles.size()<=0) {
			JOptionPane.showMessageDialog(frame_aux(), "No hay ningun articulo que eliminar", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else {
			System.out.println("\n Indiqui l'article que vol eliminar (El primer es 0) \n");
			for (int i=0; i < articles.size(); i++) {
				System.out.println(articles.get(i));
			}
			eliminar = sc.nextInt();
			articles.remove(eliminar);
			JOptionPane.showMessageDialog(frame_aux(), "Articulo eliminado correctamente", "Baja", JOptionPane.PLAIN_MESSAGE);
		}
	}

	public void modificacion() {
		boolean exit = false;
		Object[] opciones = {"1-Codigo","2-Descripcion","3-Precio de compra","4-Precio de venta","5-Salir"};
		do {
			String secundario = (String)JOptionPane.showInputDialog(frame_aux(),"Que quiere modificar?","Modificacion",JOptionPane.PLAIN_MESSAGE,null,opciones,"1-Codigo");
			if(secundario.matches("1-Codigo") == true) {
				//Mostrm els objectes que conte l'arraylist. Despres demanam el nou valor a asignar a la variable y s'asigna.
				if(articles.size()>0) {
					System.out.println("\n Quin article vol modificar? (El primer es 0) \n");
					for (int i=0; i < articles.size(); i++) {
						System.out.println(articles.get(i));
					}
					entrada = sc.nextInt();
					System.out.println("\n Quin es el codi que li vol asignar a l'article? \n");
					modificacio = sc.next();
					modificar_codi = articles.get(entrada).getCodi();
					articles.get(entrada).setCodi(modificacio);
					JOptionPane.showMessageDialog(frame_aux(), "Codigo modificada correctamente \n el nuevo codigo es: " + modificar_codi,"Modificacion del codigo del articulo", JOptionPane.PLAIN_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(frame_aux(), "No hay ningun articulo en el almacen", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			if(secundario.matches("2-Descripcion") == true) {	//Mostrm els objectes que conte l'arraylist. Despres demanam el nou valor a asignar a la variable y s'asigna.
				if(articles.size()>0) {
					System.out.println("\n Quin article vol modificar? (El primer es 0) \n ");
					for (int i=0; i < articles.size(); i++) {
						System.out.println(articles.get(i));
					}
					entrada = sc.nextInt();
					System.out.println("\n Quina es la descripcio que vol asignar a l'article? \n");
					modificacio = sc.next();
					articles.get(entrada).setDescripcio(modificacio); 		//Ficam la variable modificacio a l'objecte desitjat de l'arraylist
					JOptionPane.showMessageDialog(frame_aux(), "Descripcion modificada correctamente","Modificacion de la descripcion del articulo", JOptionPane.PLAIN_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(frame_aux(), "No hay ningun articulo en el almacen", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			if (secundario.matches("3-Precio de compra") == true) {
				if(articles.size()>0) {
					System.out.println("\n Quin article vol modificar? (El primer es 0) \n ");
					for (int i=0; i < articles.size(); i++) {
						System.out.println(articles.get(i));
					}
					entrada = sc.nextInt();
					do {
						System.out.println("\n Quin es el preu de compra que vol asignar a l'article? \n ");
						modificar_preu = sc.nextDouble();
						if (modificar_preu < 0.0) {
							JOptionPane.showMessageDialog(frame_aux(), "No puedes asignar un precio negativo", "Error", JOptionPane.ERROR_MESSAGE);
						}
						else {
							preu_a_modificar = modificar_preu;
							articles.get(entrada).setPreuDeCompra(preu_a_modificar);
							JOptionPane.showMessageDialog(frame_aux(), "Precio modificado correctamente \n el nuevo precio es: " + preu_a_modificar, "Modificacion del precio de compra", JOptionPane.PLAIN_MESSAGE);
						}
					}
					while(preu_a_modificar < 0.0);
				}
				else {
					JOptionPane.showMessageDialog(frame_aux(), "No hay ningun articulo en el almacen", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			if (secundario.matches("4-Precio de venta") == true) {
				if(articles.size()>0) {
					System.out.println("\n Quin article vol modificar? (El primer es 0) \n ");
					for (int i=0; i < articles.size(); i++) {
						System.out.println(articles.get(i));
					}
					entrada = sc.nextInt();
					System.out.println("\n Quin es el preu de venda que vol asignar a l'article? \n ");
					modificar_preu = sc.nextDouble();
					if (modificar_preu < 0.0) {
						JOptionPane.showMessageDialog(frame_aux(), "No puedes asignar un precio negativo", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else {
						preu_a_modificar = modificar_preu;
						articles.get(entrada).setPreuDeVenda(preu_a_modificar);
						JOptionPane.showMessageDialog(frame_aux(), "Precio modificado correctamente \n el nuevo precio es: " + preu_a_modificar, "Modificacion del precio de compra", JOptionPane.PLAIN_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(frame_aux(), "No hay ningun articulo en el almacen", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			if(secundario.matches("5-Salir")) {
				exit = true;
			}
		}
		while(exit != true);
	}

	public void entrada() {
		System.out.println("\n Per a quina mercaderia vol afegir stock (Comneça per 0) \n");
		for (int i=0; i < articles.size(); i++) {
			System.out.println(articles.get(i));
		}
		entrada = sc.nextInt();
		System.out.println("\n Quina es la quantitat que vol afegir? \n");
		check = sc.nextInt();
		if (check < 0) {
			JOptionPane.showMessageDialog(frame_aux(), "No pueden entrar valores negativos", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else{
			quantitat = check;
			valor_a_modificar = articles.get(entrada).getStock();
			valor_a_modificar += quantitat;
			articles.get(entrada).setStock(valor_a_modificar);
			JOptionPane.showMessageDialog(frame_aux(), "Mercancias añadidas correctamente", "Entrada", JOptionPane.PLAIN_MESSAGE);
		}
	}

	public void salida() {
		System.out.println("\n Per a quina mercaderia vol retirar stock (Comença per 0) \n");
		for (int i=0; i < articles.size(); i++) {
			System.out.println(articles.get(i));
		}
		entrada = sc.nextInt();
		System.out.println("\n Quina es la quantitat que vol retirar? \n");
		check = sc.nextInt();
		if (check < 0) {
			System.out.println("\n No pots restar valors negatius \n");
		}
		if (check >= 0) {
			quantitat = check;
		}
		valor_a_modificar = articles.get(entrada).getStock();
		if(quantitat > valor_a_modificar) {
			JOptionPane.showMessageDialog(frame_aux(), "De esta mercancia solo quedan/a " + valor_a_modificar + " unidades/d", "Error", JOptionPane.ERROR_MESSAGE);
			
		}
		else {
			valor_a_modificar -= quantitat;		//El mateix que a la suma pero aqui restam el valor de les variables.
			articles.get(entrada).setStock(valor_a_modificar);
			JOptionPane.showMessageDialog(frame_aux(), "Mercancias eliminadas correctamente", "Salida", JOptionPane.PLAIN_MESSAGE);
		}
	}

	public static void main(String[]args) {
		almacen_grafico kk = new almacen_grafico();
		if((kk.frame() != null)&& kk.frame().length()>0) {
			do {
			}
			while(kk.frame().matches("7-Salir") != true);
		}
	}
}