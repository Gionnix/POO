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
	public boolean equals(Object o) {
		if (!(o instanceof Punto)) return false;
		if (o == this) return true;
		Punto p = (Punto)o;
	 	return x == p.x && y == p.y;
	} // equals
	public int hashCode() { // Metodo di hash 
		final int PRIMO = 17;
		long X = Double.doubleToLongBits(x);
		long Y = Double.doubleToLongBits(y);
		return ((int)(X ^ (X >>> 32))) * PRIMO + (int)(Y ^ (Y >>> 32));
	} // hashCode
} // Punto
