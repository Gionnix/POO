package poo.banca;

public class ContoBancario {
	private String numero;
	private double bilancio;
	public ContoBancario(String numero) {
		this.numero = numero;
	} // Costruttore 1
	public ContoBancario(String numero, double bilancio) {
		if (bilancio <= 0) throw new IllegalArgumentException();
		this.numero = numero; this.bilancio = bilancio;
	} // Costruttore 2
	public String conto() { return numero; }   // Metodi
	public double saldo() { return bilancio; } // getter
	public void deposita(double quanto) {
		if (quanto <= 0) throw new IllegalArgumentException();
		bilancio += quanto;
	} // deposita
	public boolean preleva(double quanto) {
		if (quanto <= 0) throw new IllegalArgumentException();
		if (quanto > bilancio) return false;
		bilancio -= quanto;
		return true;
	} // preleva
	public String toString() {
		return numero + " E" + String.format("%1.2f", bilancio);
	} // toString
} // ContoBancario
