package poo.geometria;

public class Poligono {
	private Punto vertici[];
	private double lati[];
	public Poligono(Punto[]v) {
		// Si assume che l'insieme di punti formi un poligono convesso
		vertici = new Punto[v.length];
		lati = new double[v.length];
		for (int i = 0; i < v.length; i++) {
			vertici[i] = new Punto(v[i]);
			lati[i] = v[i].distanza(v[(i < v.length - 1 ? i + 1 : 0)]);
		}
	} // Costruttore normale
	public Punto[] getVertici() {
		Punto v[] = new Punto[vertici.length];
		for (int i = 0; i < v.length; i++)
			v[i] = new Punto(vertici[i]);
		return v;
	} // getVertici
	public double[] getLati() {
		double l[] = new double[lati.length];
		for (int i = 0; i < l.length; i++)
			l[i] = lati[i];
		return l;
	} // getLati
	public double perimetro() {
		double p = 0;
		for (int i = 0; i < lati.length; i++)
			p += lati[i];
		return p;
	} // perimetro
	public double area() {
		double a = 0; Triangolo t;
		for (int i = 1; i < vertici.length - 1; i++) {
			t = new Triangolo(vertici[0], vertici[i], vertici[i+1]); // Qui si ha accumulo di garbage dovuto alle ripetute modifiche del riferimento di t
			a += t.area();
		}
		return a;
	} // area
	public String toString() {
		String s = "Poligono di vertici:";
		for (int i = 0; i < vertici.length; i++)
			s = s.concat(" " + vertici[i]); // Anche qui si accumula garbage
		return s;
	}
} // Poligono
