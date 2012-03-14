package poo.banca;

public class ContoConFido extends ContoBancario {
	private double fido = 1000, scoperto;
	public ContoConFido(String numero) {
		super(numero);
	} // Costruttore 1
	public ContoConFido(String numero, double bilancio) {
		super(numero, bilancio);
	} // Costruttore 2
	public ContoConFido(String numero, double bilancio, double fido) {
		super(numero, bilancio);
		if (fido < 0) throw new IllegalArgumentException();
		this.fido = fido;
	} // Costruttore 3
	@Override public void deposita(double quanto) {
		if (quanto <= 0) throw new IllegalArgumentException();
		if (quanto <= scoperto) { scoperto -= quanto; return; }
		double residuo = quanto - scoperto;
		scoperto = 0;
		super.deposita(residuo);
	} // deposita
	// Da completare
} // ContoConFido
