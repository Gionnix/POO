package poo.util;

public class Matrix {
	// Precondizione: matrici quadrate o rettangolari
	public static boolean simmetrica(double[][]m) {
		if (m.length != m[0].length) return false;
		for (int i = 0; i < m.length; i++)
			for (int j = i; j < m[0].length; j++)
				if (m[i][j] != m[j][i])
					return false;
		return true;
	} // simmetrica
	public static double[][] trasposta(double[][]m) {
		if (m.length != m[0].length) throw new IllegalArgumentException();
		double[][] t = new double[m.length][m.length];
		for (int i = 0; i < m.length; i++)
			for (int j = 0; j < m[0].length; j++)
				t[j][i] = m[i][j];
		return t;
	} // trasposta
	public static double[][] add(double[][]m1, double[][]m2) {
		if (m1.length != m2.length || m1[0].length != m2[0].length)
			throw new IllegalArgumentException();
		double[][] s = new double[m1.length][m1[0].length];
		for (int i = 0; i < m1.length; i++)
			for (int j = 0; j < m1[0].length; j++)
				s[i][j] = m1[i][j] + m2[i][j];
		return s;
	} // add
	public static double[][] sub(double[][]m1, double[][]m2) {
		if (m1.length != m2.length || m1[0].length != m2[0].length)
			throw new IllegalArgumentException();
		double[][] d = new double[m1.length][m1[0].length];
		for (int i = 0; i < m1.length; i++)
			for (int j = 0; j < m1[0].length; j++)
				d[i][j] = m1[i][j] - m2[i][j];
		return d;
	} // sub
	public static double[][] mul(double[][]m1, double[][]m2) {
		// TODO
	} // mul
	// TODO
} // Matrix
