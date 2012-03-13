package poo.geometria;

public class Punto {
	private double x, y;
	public Punto() { x = 0; y = 0; } // Costruttore default
	public Punto(double x, double y) {
		this.x = x; this.y = y;
	} // Costruttore normale
	public Punto(Punto p) {
		x = p.x; y = p.y;
	} // Costruttore copia
	public double getX() { return x; }
	public double getY() { return y; }
	public void sposta(double x, double y) {
		this.x = x; this.y = y;
	} // sposta
	public double distanza(Punto p) {
		return Math.sqrt((p.x - x)*(p.x - x) + (p.y - y)*(p.y - y));
	} // distanza
	public String toString() {
		return String.format("<%1.2f, %1.2f>", x, y);
	} // toString
} // Punto
