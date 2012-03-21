package poo.figure;

public abstract class Figura implements FiguraPiana {
	private double dimensione;
	public Figura(double dimensione) {
		if (dimensione <= 0) throw new IllegalArgumentException();
		this.dimensione = dimensione;
	} // Costruttore base
	public double getDimensione() { return dimensione; }
	public abstract double perimetro();
	public abstract double area();
	public String toString() {
		return String.format("%1.2f\n", dimensione);
	} // toString
} // Figura
