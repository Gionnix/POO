package poo.vari;

public class Monetina {
	private int faccia;
	public static final int TESTA = 0, CROCE = 1;
	public Monetina() { lancia(); }
	public void lancia() {
		faccia = (Math.random() < 0.5 ? TESTA : CROCE);
	} // lancia
	public int getFaccia() { return faccia; }
	public String toString() {
		return (faccia == TESTA ? "Testa" : "Croce");
	} // toString
}
