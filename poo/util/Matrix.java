package poo.util;

public final class Matrix {
	// Precondizione: matrici quadrate o rettangolari
	private Matrix() {} // Sovrascrivo costruttore di default
	public static boolean simmetrica(double[][]m) {
		if (!quadrata(m)) return false;
		for (int i = 0; i < m.length; i++)
			for (int j = i + 1; j < m[0].length; j++)
				if (!Mat.circaUguali(m[i][j], m[j][i]))
					return false;
		return true;
	} // simmetrica
	public static double[][] trasposta(double[][]m) {
		if (!quadrata(m)) throw new IllegalArgumentException("Matrice non quadrata!");
		double[][] t = new double[m.length][m.length];
		for (int i = 0; i < m.length; i++)
			for (int j = 0; j < m[0].length; j++)
				t[j][i] = m[i][j];
		return t;
	} // trasposta
	public static double[][] add(double[][]m1, double[][]m2) {
		if (m1.length != m2.length || m1[0].length != m2[0].length)
			throw new IllegalArgumentException("Matrici con dimensioni diverse!");
		double[][] s = new double[m1.length][m1[0].length];
		for (int i = 0; i < m1.length; i++)
			for (int j = 0; j < m1[0].length; j++)
				s[i][j] = m1[i][j] + m2[i][j];
		return s;
	} // add
	public static double[][] sub(double[][]m1, double[][]m2) {
		if (m1.length != m2.length || m1[0].length != m2[0].length)
			throw new IllegalArgumentException("Matrici con dimensioni diverse!");
		double[][] d = new double[m1.length][m1[0].length];
		for (int i = 0; i < m1.length; i++)
			for (int j = 0; j < m1[0].length; j++)
				d[i][j] = m1[i][j] - m2[i][j];
		return d;
	} // sub
	public static double[][] mul(double[][]m1, double[][]m2) {
		if (m1[0].length != m2.length) throw new IllegalArgumentException("Matrici non moltiplicabili!");
		double[][] p = new double[m1.length][m2[0].length];
		for (int i = 0; i < p.length; i++)
			for (int j = 0; j < p[0].length; j++)
				for (int k = 0; k < m1[0].length; k++)
					p[i][j] += m1[i][k] * m2[k][j];
		return p;
	} // mul
	public static double[][] sottoMatrice(double[][]m, int i, int j, int n) {
		if (n > m.length - i || n > m[0].length - j) throw new IllegalArgumentException("Sottomatrice non presente!");
		double[][] s = new double[n][n];
		for (int r = 0; r < n; r++)
			for (int c = 0; c < n; c++)
				s[r][c] = m[i+r][j+c];
		return s;
	} // sottoMatrice
	public static double[][] minore(double[][] m, int i, int j) {
		if (!quadrata(m)) throw new IllegalArgumentException("Matrice non quadrata!");
		if (m.length == 1) throw new IllegalArgumentException("Matrice di ordine 1!");
		double[][] min = new double[m.length - 1][m[0].length - 1];
		int saltoRiga, saltoColonna;
		for (int r = 0; r < min.length; r++) {
			saltoRiga = r >= i ? 1 : 0;
			for (int c = 0; c < min[0].length; c++) {
				saltoColonna = c >= j ? 1 : 0;
				min[r][c] = m[r + saltoRiga][c + saltoColonna];
			}
		}
		return min;
	} // minore
	public static boolean quadratoMagico(double[][]m) {
		if (!quadrata(m)) throw new IllegalArgumentException("Matrice non quadrata!");
		double somma = 0, d1 = 0, d2 = 0;
		for (int i = 0; i < m.length; i++)
			d1 += m[i][i]; // Diagonale principale
		for (int i = 0; i < m.length; i++)
			d2 += m[i][m.length-1-i]; // Diagonale secondaria
		if (!Mat.circaUguali(d1, d2)) return false;
		double sommaRiga, sommaColonna;
		for (int i = 0; i < m.length; i++) {
			sommaRiga = 0; sommaColonna = 0;
			for (int j = 0; j < m.length; j++) {
				sommaRiga += m[i][j];
				sommaColonna += m[j][i];
			}
			if (!Mat.circaUguali(d1, sommaRiga) || !Mat.circaUguali(d1, sommaColonna))
				return false; // Somma di ogni riga e colonna
		}
		return true;
	} // quadratoMagico
	public static int[] sella(double[][]m) {
		for (int i = 0; i < m.length; i++) {
			int j = posMinimo(m[i]);
			if (posMassimo(trasposta(m)[j]) == i) return new int[] {i,j};
		}
		return new int[] {-1,-1};
	} // sella
	private static boolean quadrata(double[][] m) {
		return m.length == m[0].length;
	} // quadrata
	private static int posMinimo(double[]v) {
		double min = v[0]; int minpos = 0;
		for (int i = 1; i < v.length; i++)
			if (v[i] < min) { min = v[i]; minpos = i; }
		return minpos;
	} // posMinimo
	private static int posMassimo(double[]v) {
		double max = v[0]; int maxpos = 0;
		for (int i = 1; i < v.length; i++)
			if (v[i] > max) { max = v[i]; maxpos = i; }
		return maxpos;
	} // posMinimo
	public static void main(String[]args) {
		System.out.println("Matrice m:");
		double[][] m = new double[][] {{2,3,1},{3,4,6},{1,6,5}};
		for (int i = 0; i < m.length; i++)
			System.out.println(java.util.Arrays.toString(m[i]));
		System.out.println("m è simmetrica: " + simmetrica(m));
		System.out.println();
		System.out.println("Trasposta di m:");
		double[][] t = trasposta(m);
		for (int i = 0; i < t.length; i++)
			System.out.println(java.util.Arrays.toString(t[i]));
		System.out.println();
		System.out.println("Matrice somma:");
		double[][] s = add(m, t);
		for (int i = 0; i < s.length; i++)
			System.out.println(java.util.Arrays.toString(s[i]));
		System.out.println();
		System.out.println("Minore complementare (1,1) di m:");
		double[][] min = Matrix.minore(m, 1, 1);
		for (int i = 0; i < min.length; i++)
			System.out.println(java.util.Arrays.toString(min[i]));
		System.out.println();
		System.out.println("Elemento 'sella' di m: " + java.util.Arrays.toString(sella(m)));
		System.out.println();
		System.out.println("Matrice q:");
		double[][] q = new double[][] {	{16,3,2,13},
						{5,10,11,8},
						{9,6,7,12},
						{4,15,14,1} }; // Grazie a Melencolia I
		for (int i = 0; i < q.length; i++)
			System.out.println(java.util.Arrays.toString(q[i]));
		System.out.println("La matrice q è un quadrato magico: " + quadratoMagico(q));
	} // main
} // Matrix
