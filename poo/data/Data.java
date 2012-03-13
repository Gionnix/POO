package poo.data;

import java.util.*;

public class Data {
	private int g, m, a;
	public static final int GIORNO = 0, MESE = 1, ANNO = 2;
	public Data() {
		GregorianCalendar gc = new GregorianCalendar();
		this.g = gc.get(gc.DAY_OF_MONTH);
		this.m = gc.get(gc.MONTH)+1;
		this.a = gc.get(gc.YEAR);
	} // Costruttore di default: data corrente
	public Data(int g, int m, int a) {
		if (	g < 1 || g > durata(m, a) ||
			m < 1 || m > 12 || a < 0	)
			throw new IllegalArgumentException();
		this.g = g; this.m = m; this.a = a;
	} // Costruttore normale
	public Data(Data d) {
		g = d.g; m = d.m; a = d.a;
	} // Costruttore di copia
	public int getG() { return g; } // Metodi
	public int getM() { return m; } // getter
	public int getA() { return a; } // g, m, a
	public static int durata(int m, int a) {
		if (m == 4 || m == 6 || m == 9 || m == 11) return 30;
		if (m == 2)
			if (bisestile(a)) return 29;
			else return 28;
		return 31;
	} // durata mese
	public static boolean bisestile(int a) {
		return (a % 4 == 0 && (a % 100 != 0 || a % 400 == 0));
	} // bisestile
	public Data giornoDopo() {
		int newG = (g + 1 > Data.durata(m, a) ? 1 : g + 1);
		int newM = (newG == 1 ? (m + 1 > 12 ? 1 : m + 1) : m);
		int newA = (newM == 1 ? a + 1 : a);
		return new Data(newG, newM, newA);
	} // giornoDopo
	public String toString() {
		return String.format("%02d/%02d/%04d", g, m, a);
	} // toString
} // Data
