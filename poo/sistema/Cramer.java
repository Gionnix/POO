package poo.sistema;

import poo.util.*;

public class Cramer extends Sistema {
	private double[][] a; private double[] y;
	public Cramer(double[][] a, double[] y) {
		super(a, y);
		this.a = new double[a.length][a.length];
		for (int i = 0; i < a.length; i++) {
			System.arraycopy(a[i], 0, this.a[i], 0, a.length);
			this.y = new double[y.length];
			this.y[i] = y[i];
		}
	} // Costruttore normale
	public double[] risolvi() {
		double det = Matrix.determinante(a);
		if (Mat.circaUguali(det, 0D)) throw new SistemaSingolare();
		int n = getN();
		double[] x = new double[n];
		for (int i = 0; i < n; i++) {
			scambiaColonna(a, i, y);
			x[i] = Matrix.determinante(a) / det;
			scambiaColonna(a, i, y);
		}
		return x;
	} // risolvi
	private void scambiaColonna(double[][] m, int c, double[] v) {
		double tmp;
		for (int i = 0; i < m.length; i++) {
			tmp = v[i];
			v[i] = m[i][c];
			m[i][c] = tmp;
		}
	} // scambiaColonna
} // Cramer
