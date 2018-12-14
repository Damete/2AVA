package pru03.E02;

public class PRU03E02TestCotxe_damia_febrer extends CotxeAbstracte implements InterfaceCotxe {

	protected EstatsMotorCotxe estat = EstatsMotorCotxe.Aturat;
	protected TipusCanvi canvi = TipusCanvi.CanviAutomatic;
	protected Marxa marxa = Marxa.F;
	protected MarxesManuals marxamanual = MarxesManuals.primera;
	public enum Marxa {
		F,
		N,
		R;
	}
	public enum MarxesManuals{
		R,
		primera,
		segunda,
		tercera,
		cuarta,
		quinta,
		sexta;
	}

	public PRU03E02TestCotxe_damia_febrer(String marca, String model, TipusCanvi tipuscanvi) {
		super(marca, model, tipuscanvi);
	}

	@Override
	public void arrancarMotor() throws Exception {
		if(comprovaMotor().equals(EstatsMotorCotxe.Aturat)) {
			estat = EstatsMotorCotxe.EnMarxa;
		}
		else {
			throw new IllegalArgumentException("El motor ja esta enmarxa");
		}

	}

	@Override
	public EstatsMotorCotxe comprovaMotor() {
		return estat;
	}

	public Marxa CanviarMarxaAutomatic() throws Exception {
		if (canvi.equals(TipusCanvi.CanviAutomatic)) {
			if (marxa.equals(Marxa.F)) {
				System.out.println("La marcha es F");
			}
			if(marxa.equals(Marxa.R)) {
				System.out.println("La marxa es R");
			}
			if(marxa.equals(Marxa.N)) {
				System.out.println("La marxa es N");
			}
			else {
				throw new Exception("La marxa es incorrecte");
			}
		}
		return marxa;
	}
	
	public MarxesManuals CanviarMarxaManual() throws Exception{
		
	}

	@Override
	public int getRevolucions() {
		if(comprovaMotor().equals(EstatsMotorCotxe.EnMarxa)) {
			return (int)(Math.random() * 6500);
		}
		else {
			return 0;
		}
	}

	@Override
	public void aturarMotor() throws Exception {
		if(comprovaMotor().equals(EstatsMotorCotxe.Aturat)) {
			throw new IllegalArgumentException("El cotxe ja esta aturat");
		}
		else {
			estat = EstatsMotorCotxe.Aturat;
		}
	}

	public static void main (String[] args) throws Exception {
		PRU03E02TestCotxe_damia_febrer PIPO = new PRU03E02TestCotxe_damia_febrer("Seat", "Ibiza", TipusCanvi.CanviAutomatic);{
			PIPO.arrancarMotor();
			System.out.println(PIPO.comprovaMotor());
			System.out.println(PIPO.getRevolucions());
			PIPO.aturarMotor();
			System.out.println(PIPO.comprovaMotor());
			System.out.println(PIPO.getRevolucions());
		}
	}
}