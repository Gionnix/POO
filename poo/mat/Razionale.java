package poo.mat;

public class Razionale {
	private int num, den;
	private static int contatore = 0;
	public Razionale(int n, int d) {
		if (d == 0) {
			System.out.println("Denominatore nullo!");
			System.exit(-1);
		}
		if (n != 0) {
			int MCD = Mat.mcd(Math.abs(n), Math.abs(d));
			n /= MCD; d /= MCD; // Riduzione ai minimi termini
		}
		if (d < 0) { n *= -1; d *= -1; } // Porto il segno al numeratore
		num = n; den = d;
		contatore++;
	} // Costruttore normale
	public Razionale(Razionale r) {
		num = r.num; den = r.den;
		contatore++;
	} // Costruttore copia
	public int getNum() { return num; }
	public int getDen() { return den; }
	public static int getContatore() { return contatore; }
	protected void finalize() {
		contatore--;
	} // finalize
	public Razionale mul(int s) {
		return new Razionale(s * num, den);
	} // Moltiplicazione per uno scalare
	public Razionale mul(Razionale r) {
		return new Razionale(num * r.num, den * r.den);
	} // Moltiplicazione per un altro Razionale
	public Razionale div(Razionale r) {
		return new Razionale(num * r.den, den * r.num);
	} // Divisione per un altro Razionale
	public Razionale add(Razionale r) {
		int mcm = Mat.mcm(den, r.den);
		return new Razionale((mcm / den) * num + (mcm / r.den) * r.num, mcm);
	} // Addizione con un altro Razionale
	public Razionale sub(Razionale r) {
		int mcm = Mat.mcm(den, r.den);
		return new Razionale((mcm / den) * num - (mcm / r.den) * r.num, mcm);
	} // Sottrazione con un altro Razionale
	public String toString() {
		return (num == 0 ? "0" : (num > 0 ? "+" : "") + num + (den != 1 ? "/" + den : "") );
	} // toString
} // Razionale
