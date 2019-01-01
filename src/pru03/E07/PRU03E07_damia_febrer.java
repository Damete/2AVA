package pru03.E07;
import java.util.ArrayList;
import java.util.Scanner;

public class PRU03E07_damia_febrer {
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

	public void menu() {
		int menu_principal;

		String codi;
		String descripcio;
		double preuDeCompra;
		double preuDeVenda;
		int stock;
		int eliminar;
		int modificar;
		int entrada;
		do {
			System.out.println("Quina operacio vol realitzar? \n 1. Llistat \n 2. Alta \n 3. Baixa \n 4. Modificacio \n 5. Entrada de mercaderia \n 6. Sortida de mercaderia \n 7. Sortir \n");
			menu_principal = sc.nextInt();
			if (menu_principal == 1) {//Esta opcion no esta acabada !!

			}
			if (menu_principal == 2) {
				System.out.println("\n Introdueixi el codi de l'article \n");
				codi = sc.next();
				System.out.println("\n Introdueixi la descripcio de l'article \n");
				descripcio = sc.next();
				System.out.println("\n Intordueixi el preu de compra de l'article \n");
				preuDeCompra = sc.nextDouble();
				System.out.println("\n Introdueixi el preu de venta de l'article \n");
				preuDeVenda = sc.nextDouble();
				System.out.println("\n Intordueixi el stock de l'article \n");
				stock = sc.nextInt();
				Article pipo = new Article();
				pipo.setCodi(codi);
				pipo.setDescripcio(descripcio);
				pipo.setPreuDeCompra(preuDeCompra);
				pipo.setPreuDeVenda(preuDeVenda);
				pipo.setStock(stock);
				System.out.println(pipo.toString());
				articles.add(pipo);
			}
			if (menu_principal == 3) {
				System.out.println("Indiqui l'article que vol eliminar");
				eliminar = sc.nextInt();
				articles.remove(eliminar);
			}
			if (menu_principal == 4) {//Esta opcion no esta acabada !!
				System.out.println();
				modificar = sc.nextInt();
			}
			if (menu_principal == 5) {//Esta opcion no esta acabada !!
				System.out.println("Introdueixi el nombre de mercaderies que entren");
				entrada = sc.nextInt();
			}
			if (menu_principal == 6) {//Esta opcion no esta acabada !!
				
			}
		}
		while(menu_principal != 7);
	}
	public static void main (String[] args) {
		PRU03E07_damia_febrer pipo = new PRU03E07_damia_febrer();
		pipo.menu();
	}

}