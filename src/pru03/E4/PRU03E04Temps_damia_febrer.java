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