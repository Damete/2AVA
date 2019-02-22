package Grafico;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import pru03.E07.PRU03E07_damia_febrer.Article;

/*Esto se destina a modificar el ejercicio del almacen pasando el menú al entorno gráfico*/

public class almacen_grafico {
	Scanner sc = new Scanner(System.in);
	ArrayList<Article> articles = new ArrayList<Article>();

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

	public void listado() {
		for (int i=0; i < articles.size(); i++) {
			System.out.println(articles.get(i));
		}
		if(articles.size() <= 0) {
			JFrame main = new JFrame();
			JOptionPane.showMessageDialog(main," Encara no hi ha cap article al magatzem" , "Es lo que hay", JOptionPane.ERROR_MESSAGE);
		}
	}
	public void menu() {//El menu solo acabara cuando el usuario lo indique.
		int menu_principal;
		int menu_secundari;
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
		String modificacio="0";
		double modificar_preu;
		double preu_a_modificar;
		double comprovar_preu;

		Object[] opciones = {"1. Llistat","2. Alta","3. Baixa","4. Modificacio","5. Entrada de mercaderia","6. Sortida de mercaderia","7. Sortir"};
		JFrame main = new JFrame();
		String principal = (String)JOptionPane.showInputDialog(main, "Que vols fer?", "Menu principal",JOptionPane.PLAIN_MESSAGE,null, opciones, "1. Llistat");
		menu_principal = sc.nextInt();
		if ((principal != null)&& principal.length()>0) {
			JOptionPane.showMessageDialog(main,"Esto es lo que hay en el almacen", "Listado",JOptionPane.PLAIN_MESSAGE,null);
			listado();
		}
		if (menu_principal == 2) {	//Aqui cream un nou objecte amb els valors que asignam per teclat i l'afegim a l'arraylist
			System.out.println("\n Introdueixi el codi de l'article \n");
			codi = sc.next();
			System.out.println("\n Introdueixi la descripcio de l'article \n");
			descripcio = sc.next();
			System.out.println("\n Intordueixi el preu de compra de l'article \n");
			comprovar_preu = sc.nextDouble();
			if(comprovar_preu < 0) {	//Comprobam que el valor que asignam al preu no sigui negatiu
				System.out.println("\n No pots asignar un valor negatiu \n");
			}
			if(comprovar_preu >= 0) {
				preuDeCompra = comprovar_preu;
			}
			System.out.println("\n Introdueixi el preu de venda de l'article \n");
			comprovar_preu = sc.nextDouble();
			if(comprovar_preu < 0) {	//Comprobam que el valor que asignam al preu no sigui negatiu
				System.out.println("\n No es pot asignar un numero negatiu \n");
			}
			if(comprovar_preu >= 0) {
				preuDeVenda = comprovar_preu;
			}
			System.out.println("\n Intordueixi el stock de l'article \n");
			check = sc.nextInt();
			if (check < 0) {	//Comprobam que el valor que asignam a l'estock no sigui negatiu
				System.out.println("\n No es poden asignar valors negatius \n");
			}
			if (check >= 0) {
				stock = check;
			}
			Article pipo = new Article();
			pipo.setCodi(codi);
			pipo.setDescripcio(descripcio);
			pipo.setPreuDeCompra(preuDeCompra);
			pipo.setPreuDeVenda(preuDeVenda);
			pipo.setStock(stock);
			System.out.println(pipo.toString());
			articles.add(pipo);
		}
		if (menu_principal == 3) {	//Eliminam de l'arraylist l'objecte que introduiguem per teclat. Primer mostrarm tots els objectes que conte l'arraylist
			System.out.println("\n Indiqui l'article que vol eliminar (El primer es 0) \n");
			for (int i=0; i < articles.size(); i++) {
				System.out.println(articles.get(i));
			}
			eliminar = sc.nextInt();
			articles.remove(eliminar);
		}
		if (menu_principal == 4) {
			do {
				System.out.println("\n Quin camp vol modificar? \n 1. Codi \n 2. Descripcio \n 3. Preu de compra \n 4. Preu de Venda \n 5. Sortir \n");
				menu_secundari = sc.nextInt();
				if(menu_secundari == 1) {
					//Mostrm els objectes que conte l'arraylist. Despres demanam el nou valor a asignar a la variable y s'asigna.
					System.out.println("\n Quin article vol modificar? (El primer es 0) \n");
					for (int i=0; i < articles.size(); i++) {
						System.out.println(articles.get(i));
					}
					entrada = sc.nextInt();
					System.out.println("\n Quin es el codi que li vol asignar a l'article? \n");
					modificacio = sc.next();
					modificar_codi = articles.get(entrada).getCodi();
					modificar_codi = modificacio;
					articles.get(entrada).setCodi(modificar_codi);
				}
				if(menu_secundari == 2) {	//Mostrm els objectes que conte l'arraylist. Despres demanam el nou valor a asignar a la variable y s'asigna.
					System.out.println("\n Quin article vol modificar? (El primer es 0) \n ");
					for (int i=0; i < articles.size(); i++) {
						System.out.println(articles.get(i));
					}
					entrada = sc.nextInt();
					System.out.println("\n Quina es la descripcio que vol asignar a l'article? \n");
					modificacio = sc.next();
					modificar_codi = articles.get(entrada).getDescripcio(); 	//Agafam el valor que te la variable de lobjecte desitjat de l'arraylist en aquest cas es entrada per poder introduiro per teclat
					modificar_codi = modificacio;								//Asignam el valor que volem modificar a la variable que hem obtingut abans
					articles.get(entrada).setDescripcio(modificar_codi); 		//Ficam la variable modificada a l'objecte desitjat de l'arraylist
				}
				if (menu_secundari == 3) {
					System.out.println("\n Quin article vol modificar? (El primer es 0) \n ");
					for (int i=0; i < articles.size(); i++) {
						System.out.println(articles.get(i));
					}
					entrada = sc.nextInt();
					System.out.println("\n Quin es el preu de compra que vol asignar a l'article? \n ");
					modificar_preu = sc.nextDouble();
					if (modificar_preu < 0.0) {
						System.out.println("\n No pots asignar valors negatius \n");
					}
					preu_a_modificar = articles.get(entrada).getPreuDeCompra();
					if (modificar_preu >= 0.0) {
						preu_a_modificar = modificar_preu;
					}
					articles.get(entrada).setPreuDeCompra(preu_a_modificar);
				}
				if (menu_secundari == 4) {
					System.out.println("\n Quin article vol modificar? (El primer es 0) \n ");
					for (int i=0; i < articles.size(); i++) {
						System.out.println(articles.get(i));
					}
					entrada = sc.nextInt();
					System.out.println("\n Quin es el preu de venda que vol asignar a l'article? \n ");
					modificar_preu = sc.nextDouble();
					if (modificar_preu < 0.0) {
						System.out.println("\n No pots asignar numeros negatius \n");
					}
					preu_a_modificar = articles.get(entrada).getPreuDeVenda();
					if (modificar_preu >= 0.0) {
						preu_a_modificar = modificar_preu;
					}
					articles.get(entrada).setPreuDeVenda(preu_a_modificar);
				}
			}
			while(menu_secundari !=5);
		}
		if (menu_principal == 5) {
			System.out.println("\n Per a quina mercaderia vol afegir stock (Comneça per 0) \n");
			for (int i=0; i < articles.size(); i++) {
				System.out.println(articles.get(i));
			}
			entrada = sc.nextInt();
			System.out.println("\n Quina es la quantitat que vol afegir? \n");
			check = sc.nextInt();
			if (check < 0) {
				System.out.println("\n No pots asignar valors negatius \n");
			}
			if (check >= 0) {
				quantitat = check;
			}
			valor_a_modificar = articles.get(entrada).getStock();		//Asignam a la variable valor_a_modificar el valor de la variable stock de l'objecte que es troba a la posicio de l'arraylist indicada mitjançant la variable entrada
			valor_a_modificar += quantitat;								//Sumam al valor d'aquesta variable el valor d'una variable que hem introduit per teclat
			articles.get(entrada).setStock(valor_a_modificar);			//Una vegada sumat asignam el valor de la variable valor_a_modificar a la variable stock de l'objecte de l'arraylist que indiquem mitjancçant la variable entrada
		}
		if (menu_principal == 6) {
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
				System.out.println("\n D'aquest article nomes queda/en " + valor_a_modificar + " unitat/s \n");
			}
			if(quantitat <= valor_a_modificar) {
				valor_a_modificar -= quantitat;		//El mateix que a la suma pero aqui restam el valor de les variables.
				articles.get(entrada).setStock(valor_a_modificar);
			}
		}
	}
	public class ventanita{
		JFrame main = new JFrame();
		Object[] opciones = {"Iniciar","Salir"};
		String menu = (String)JOptionPane.showInputDialog(main, "Bienvenido al aplicativo", "Cancer Software Company",JOptionPane.PLAIN_MESSAGE,null,opciones, "Iniciar");
		if((menu != null) && menu.length()>0) {

		}
		else {
			main.setDefaultCloseOperation(main.EXIT_ON_CLOSE);
		}
	}



	public static void main (String[] args) {
		ventanita ventana = new ventanita();
	}
}
}
