package pru03.E02;

import java.util.Scanner;

public class PRU03E02Cotxe_damia_febrer extends CotxeAbstracte implements InterfaceCotxe {

	Scanner sc = new Scanner(System.in);
	protected EstatsMotorCotxe estat = EstatsMotorCotxe.Aturat;
	protected Marxa marxa = Marxa.F;
	protected MarxesManuals marxamanual = MarxesManuals.primera;
	//Aqui definimos los enum que contendras las marchas que podremos elegir en los distintos tipos de cambio de marchas
	public enum Marxa {
		F,
		N,
		R;
	}
	public enum MarxesManuals{
		R,
		primera,
		segona,
		tercera,
		cuarta,
		quinta,
		sexta;
	}

	public PRU03E02Cotxe_damia_febrer(String marca, String model, TipusCanvi tipuscanvi) {
		super(marca, model, tipuscanvi);
	}

	// Aqui definimos el metodo que arranca el motor del coche, si el motor ya esta encendido da un error debido a que no puedes encenderlo ya que ya lo esta
	@Override
	public void arrancarMotor() throws Exception {
		if(comprovaMotor().equals(EstatsMotorCotxe.Aturat)) {
			estat = EstatsMotorCotxe.EnMarxa;
		}
		else {
			throw new IllegalArgumentException("El motor ja esta enmarxa");
		}

	}

	//Aqui definimos el metodo que comprobara el estado del motor es decir si esta encencido o apagado para ello utiliza una variable en la que se almacena el estado del coche
	@Override
	public EstatsMotorCotxe comprovaMotor() {
		return estat;
	}

	// Aqui definimos el metodo que comprobara las revoluciones del motor. Para ello primero comprueba si el motor esta encendido, si es asi devuelve un numero aleatorio entre 0 y 6500. Si el motor esta apagado devuelve 0
	@Override
	public int getRevolucions() {
		if(comprovaMotor().equals(EstatsMotorCotxe.EnMarxa)) {
			return (int)(Math.random() * 6500);
		}
		else {
			return 0;
		}
	}

	//Aqui definimos el metodo que parara el motor, para ello primero comprueba si esta encencdido, si lo esta lo para modificando la variable que contiene el valor del estado del motor y si no da un error
	@Override
	public void aturarMotor() throws Exception {
		if(comprovaMotor().equals(EstatsMotorCotxe.Aturat)) {
			throw new IllegalArgumentException("El cotxe ja esta aturat");
		}
		else {
			estat = EstatsMotorCotxe.Aturat;
		}
	}

	//Aqui definimos el metodo que cambiara las marchas en caso de que el coche sea automatico. Tiene un menu en el que se nos pide que marcha queremos poner y que acabara cunado se le introduzca el valor indicado. Para cambiar de marcha primero comprueba si ya esta en la marcha a la que se quiere cambiar, si es asi da un error, si no cambia a la marcha indicada modificando el valor de la variable y muestra por pantalla la marcha a la que ha cambiado. 
	public Marxa CanviarMarxaAutomatic() {
		boolean menu = false;
		int seleccio;
		if (tipuscanvi.equals(TipusCanvi.CanviAutomatic) && estat.equals(EstatsMotorCotxe.EnMarxa)) {
			do {
				System.out.println("Cambiam de marxa? \n 1-F \n 2-N \n 3-R \n 4-Sortir");
				seleccio = sc.nextInt();
				switch(seleccio) {
				case 1: 
					if (marxa.equals(Marxa.F)) {
						System.out.println("Ja estas en aquesta marxa");
					}
					else {
						marxa=Marxa.F;
						System.out.println("Has cambiat la marxa a " + marxa);
					}
					break;
				case 2:
					if (marxa.equals(Marxa.N)) {
						System.out.println("Ja estas en aquesta marxa");
					}
					else {
						marxa=Marxa.N;
						System.out.println("Has cambiat la marxa a " + marxa);
					}
					break;
				case 3:
					if(marxa.equals(Marxa.R)){
						System.out.println("Ja estas en aquesta marxa");
					}
					else {
						marxa=Marxa.R;
						System.out.println("Has cambiat la marxa a " + marxa);
					}			
					break;
				case 4:
					System.out.println("Chau");
					menu=true;
					break;
				default:
					System.out.println("No hi ha tantes marxes fiera");
				}
			}
			while(menu !=true);
		}
		else {
			System.out.println("Aquest cotxe no es de canvi manual");
		}
		return marxa;
	}

	//Aqui definimos el metodo que cambiara de marcha en caso de que el coche sea manual. Tiene un menu que realiza la misma funcion que en el metodo para las marchas automaticas. Para cambiar entre las marchas manuales lo que hace es comprobar que no este ya en esa marcha y ya que queremos que este cambio de marchas sea secuencial tambien comprueba que se encuentre solo 1 marcha por encima o por debajo de la marcha a la que queremos cambiar. Si es asi cambia a la marcha que se le indica
	public MarxesManuals CanviarMarxaManual(){
		boolean menu = false;
		int shift;
		if(tipuscanvi.equals(TipusCanvi.CanviManual) && estat.equals(EstatsMotorCotxe.EnMarxa)) {
			do {
				System.out.println("Cambiam de marxa? \n 1-Primera \n 2-Segona \n 3-Tercera \n 4-Cuarta \n 5-Quinta \n 6-Sexta \n 7-Marxa Enrera \n 8-Sortir");
				shift = sc.nextInt();
				switch(shift) {
				case 1:
					if (marxamanual.equals(MarxesManuals.primera) || marxamanual.equals(MarxesManuals.tercera) || marxamanual.equals(MarxesManuals.cuarta) || marxamanual.equals(MarxesManuals.quinta) || marxamanual.equals(MarxesManuals.sexta) || marxamanual.equals(MarxesManuals.R)) {
						System.out.println("No pots cambiar a aquesta marxa");
					}
					else {
						marxamanual=MarxesManuals.primera;
						System.out.println("Has cambiat a " + marxamanual);
					}
					break;
				case 2:
					if (marxamanual.equals(MarxesManuals.segona) || marxamanual.equals(MarxesManuals.cuarta) || marxamanual.equals(MarxesManuals.quinta) || marxamanual.equals(MarxesManuals.sexta) || marxamanual.equals(MarxesManuals.R)) {
						System.out.println("No pots pasar a aquesta marxa");
					}
					else {
						marxamanual=MarxesManuals.segona;
						System.out.println("Has cambiat a " + marxamanual);
					}
					break;
				case 3:
					if (marxamanual.equals(MarxesManuals.tercera) || marxamanual.equals(MarxesManuals.primera) || marxamanual.equals(MarxesManuals.quinta) || marxamanual.equals(MarxesManuals.sexta) || marxamanual.equals(MarxesManuals.R)) {
						System.out.println("No pots pasar a aquesta marxa");
					}
					else {
						marxamanual=MarxesManuals.tercera;
						System.out.println("Has cambiat a " + marxamanual);
					}
					break;
				case 4:
					if (marxamanual.equals(MarxesManuals.cuarta) || marxamanual.equals(MarxesManuals.primera) || marxamanual.equals(MarxesManuals.segona) || marxamanual.equals(MarxesManuals.sexta) || marxamanual.equals(MarxesManuals.R)) {
						System.out.println("No pots pasar a aquesta marxa");
					}
					else {
						marxamanual=MarxesManuals.cuarta;
						System.out.println("Has cambiat a " + marxamanual);
					}
					break;
				case 5:
					if (marxamanual.equals(MarxesManuals.quinta) || marxamanual.equals(MarxesManuals.primera) || marxamanual.equals(MarxesManuals.segona) || marxamanual.equals(MarxesManuals.tercera) || marxamanual.equals(MarxesManuals.R)) {
						System.out.println("No pots pasar a aquesta marxa");
					}
					else {
						marxamanual=MarxesManuals.quinta;
						System.out.println("Has cambiat a " + marxamanual);
					}
					break;
				case 6:
					if (marxamanual.equals(MarxesManuals.sexta) || marxamanual.equals(MarxesManuals.primera) || marxamanual.equals(MarxesManuals.segona) || marxamanual.equals(MarxesManuals.tercera) || marxamanual.equals(MarxesManuals.cuarta)) {
						System.out.println("No pots pasar a aquesta marxa");
					}
					else {
						marxamanual=MarxesManuals.sexta;
						System.out.println("Has cambiat a " + marxamanual);
					}
					break;
				case 7:
					if (marxamanual.equals(MarxesManuals.R) || marxamanual.equals(MarxesManuals.primera) || marxamanual.equals(MarxesManuals.segona) || marxamanual.equals(MarxesManuals.tercera) || marxamanual.equals(MarxesManuals.cuarta) || marxamanual.equals(MarxesManuals.quinta)) {
						System.out.println("No pots pasar a aquesta marxa");
					}
					else {
						marxamanual=MarxesManuals.R;
						System.out.println("Has cambiat a " + marxamanual);
					}
					break;
				case 8:
					System.out.println("Chau");
					menu=true;
					break;

				default:
					System.out.println("No hi ha tantes marches bestia");
				}
			}
			while(menu!=true);
		}
		else {
			System.out.println("Aquest cotxe no es de canvi manual");
		}
		return marxamanual;
	}
}