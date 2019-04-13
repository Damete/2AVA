package PR3AVAEX01;

public class PR3AVAEX01Rational {
	private static int numerador;
	private static int denominador;

	public PR3AVAEX01Rational(int numerador, int denominador) {
		this.numerador = numerador;
		this.denominador = denominador;
	}

	public PR3AVAEX01Rational() {
		numerador = 1;
		denominador = 2;
	}

	public boolean reducible() {
		boolean reducible = false;

		if(numerador % 2 == 0 || numerador % 3 == 0 || numerador % 5 == 0 || numerador % 7 == 0 || numerador % 11 == 0 || numerador % 13 == 0) {
			if(denominador % 2 == 0 || denominador % 3 == 0 || denominador % 5 == 0 || denominador % 7 == 0 || denominador % 11 == 0 || denominador % 13 == 0) {
				reducible = true;
			}
		}

		return reducible;
	}

	public void kk() {
		if (reducible() == true) {
			System.out.println("GG EZ");
		}
	}

	public static void sumar(int nuevo_num, int nuevo_den) {
		int [] mcm_denominador = new int[20];
		int [] mcm_segundo_den = new int[20];
		int mcm = 0, b = 1, num_primera, num_segunda;
		boolean found = false;
		if(denominador == nuevo_den) {
			numerador = numerador + nuevo_num;
		}
		else {
			for(int i = 0; i<20; i++) {
				mcm_denominador[i] = denominador * i;
			}
			for(int i = 0; i<20; i++) {
				mcm_segundo_den[i] = nuevo_den * i;
			}
			do {
				for(int i = 0; i<20; i++) {
					if(mcm_denominador[b] == mcm_segundo_den[i]) {
						mcm = mcm_denominador[b];
						found = true;
					}
				}
				b++;
			}
			while(found != true);
			num_primera = (mcm / denominador) * numerador;
			num_segunda = (mcm / nuevo_den) * nuevo_num;
			numerador = num_primera + num_segunda;
			denominador = mcm;
		}
	}
	
	public static void resta(int nuevo_num, int nuevo_den) {
		int [] mcm_denominador = new int[20];
		int [] mcm_segundo_den = new int[20];
		int mcm = 0, b = 1, num_primera, num_segunda;
		boolean found = false;
		if(denominador == nuevo_den) {
			numerador = numerador - nuevo_num;
		}
		else {
			for(int i = 0; i<20; i++) {
				mcm_denominador[i] = denominador * i;
			}
			for(int i = 0; i<20; i++) {
				mcm_segundo_den[i] = nuevo_den * i;
			}
			do {
				for(int i = 0; i<20; i++) {
					if(mcm_denominador[b] == mcm_segundo_den[i]) {
						mcm = mcm_denominador[b];
						found = true;
					}
				}
				b++;
			}
			while(found != true);
			num_primera = (mcm / denominador) * numerador;
			num_segunda = (mcm / nuevo_den) * nuevo_num;
			numerador = num_primera - num_segunda;
			denominador = mcm;
		}
	}
	
	public static void multiplicar(int nuevo_num, int nuevo_den) {
		
	}
	
	public static void dividir(int nuevo_num, int nuevo_den) {
		int numerador_final, denominador_final;
		numerador_final = numerador * nuevo_den;
		denominador_final = denominador * nuevo_num;
		numerador = numerador_final;
		denominador = denominador_final;
	}
	
	public static void MostrarString() {
		System.out.println(Integer.toString(numerador) + "/" + Integer.toString(denominador));
	}

	public void mostrarnum() {
		System.out.println(numerador);
	}
	public void mostrarden() {
		System.out.println(denominador);
	}
}