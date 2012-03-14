package poo.vari;

public class Monetina {
	public enum Faccia {TESTA, CROCE}
	private Faccia faccia;
	public Monetina() { lancia(); }
	public void lancia() {
		faccia = (Math.random() < 0.5 ? Faccia.TESTA : Faccia.CROCE);
	} // lancia
	public Faccia getFaccia() { return faccia; }
	public String toString() {
		return (faccia == Faccia.TESTA ? "Testa" : "Croce");
	} // toString
}
