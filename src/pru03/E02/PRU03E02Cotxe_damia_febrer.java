package pru03.E02;

public class PRU03E02Cotxe_damia_febrer extends CotxeAbstracte implements InterfaceCotxe {

	protected EstatsMotorCotxe estat = EstatsMotorCotxe.Aturat;

	public PRU03E02Cotxe_damia_febrer(String marca, String model, TipusCanvi tipuscanvi) {
		super(marca, model, tipuscanvi);
	}

	@Override
	public void arrancarMotor() throws Exception {
		if(estat.equals(EstatsMotorCotxe.Aturat)) {
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

	@Override
	public int getRevolucions() {
		if(estat.equals(EstatsMotorCotxe.EnMarxa)) {
			return (int)(Math.random() * 6500);
		}
		else {
			return 0;
		}
	}

	@Override
	public void aturarMotor() throws Exception {
		if(estat.equals(EstatsMotorCotxe.Aturat)) {
			throw new IllegalArgumentException("El cotxe ja esta aturat");
		}
		else {
			estat = EstatsMotorCotxe.Aturat;
		}
	}
	public static void main (String[] args) {
		PRU03E02Cotxe_damia_febrer PIPO = new PRU03E02Cotxe_damia_febrer("Seat", "Ibiza", TipusCanvi.CanviManual);{
			PIPO.comprovaMotor();
		}
	}
}