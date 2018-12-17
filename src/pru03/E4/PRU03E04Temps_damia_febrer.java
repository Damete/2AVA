package pru03.E4;

public class PRU03E04Temps_damia_febrer {

	public PRU03E04Temps_damia_febrer(int hores, int minuts, int segons) {
		this.hores=hores;
		this.minuts=minuts;
		this.segons=segons;
	}

	int hores;
	int minuts;
	int segons;

	//Aqui tenemos el metodo que se encarga de hacer las sumas. Para ello comprueba si la suma de los segundos es mayor a 60, si lo es añade 1 minuto, lo mismo con los minutos, si es mayor a 60 suma 1 hora. Esto lo hara mientras los minutos y los segundos sean mayores a 60
	public String sumar(int hores,int minuts,int segons) {
		int pipo_minuts = 0;
		int pipo_segons = 0;
		do {
			if (this.segons + segons>=60) {
				pipo_segons-= 60;
				minuts+= 1;
			}
			if (this.minuts + minuts>=60) {
				pipo_minuts-=60;
				hores+=1;
			}
			pipo_minuts = pipo_minuts + this.minuts + minuts;
			pipo_segons = pipo_segons + this.segons + segons;
		}
		while ((this.minuts + minuts)>60 && (this.segons + segons)>60);
		return "La suma es:" + (this.hores + hores) + "h" + pipo_minuts + "m" + pipo_segons + "s";
	}

	// Aqui tenemos el metodo que se encarga de hacer las restas. Para ello comprueba si la resta de los segundos da negativo, si es asi resta 1 minuto y suma 60 segundos para compensar el numero negativo. En los minutos lo mismo, si el resultado es negativo resta 1hora. Esto lo hara mientras los minutos y los segundos sean inferiores a 0
	public String restar(int hores, int minuts, int segons) {
		int pipo_minuts = 0;
		int pipo_segons = 0;
		do {
			if (this.segons - segons + pipo_segons< 0) {
				pipo_segons += 60;
				minuts-=1;
			}
			if (this.minuts - minuts + pipo_minuts< 0) {
				pipo_minuts += 60;
				hores-=1;
			}
			pipo_minuts = pipo_minuts + (this.minuts - minuts);
			pipo_segons = pipo_segons + (this.segons - segons);
		}
		while (pipo_minuts < 0 && pipo_segons < 0);
		return "La resta es:" + (this.hores - hores) + "h" + pipo_minuts + "m" + pipo_segons + "s";
	}

	@Override public String toString() {
		return hores + "h" + minuts + "m" + segons + "s";
	}
}