package poo.geometria;

public class Disco extends Punto {
	private double raggio;
	public Disco() { super(); raggio = 1; } // Costruttore di default
	public Disco(double x, double y, double raggio) {
		super(x, y); this.raggio = raggio;
	} // Costruttore 1
	public Disco(Punto centro, double raggio) {
		super(centro); this.raggio = raggio;
	} // Costruttore 2
	public Disco(Disco d) {
		super(d); raggio = d.raggio;
	} // Costruttore di copia
	public double area() {
		return Math.PI * raggio * raggio;
	} // area
	public double perimetro() {
		return 2 * Math.PI * raggio;
	} // perimetro
	public String toString() {
		return "Disco di centro: " + super.toString() + String.format(" e raggio = %1.2f", raggio);
	} // toString
} // Disco
