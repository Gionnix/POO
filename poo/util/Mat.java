package poo.util;

public final class Mat {
	private static double EPSILON = 1.0E-14;
	private Mat() {}
	public static double getEpsilon() { return EPSILON; }
	public static void setEpsilon(double EPSILON) {
		Mat.EPSILON = EPSILON;
	} // setEpsilon
	public static boolean circaUguali(double x, double y) {
		return Math.abs(x - y) <= EPSILON;
	} // circaUguali
	public static int mcd(int x, int y) {
		if (x <= 0 || y <= 0) throw new IllegalArgumentException();
		return mcd_euclide(x, y);
	} // mcd
	private static int mcd_euclide(int x, int y) {
		if (y == 0) return x;
		return mcd_euclide(y, x % y);
	} // mcd_euclide
	public static int mcm(int x, int y) {
		return (x * y) / mcd(x, y);
	} // mcm
	public static int fibo(int n) {
		// Pre: n > 0
		if (n < 3) return 1;
		int[][] m = {{1, 1}, {1, 0}};
		int[][] mp = matricePotenza(m, n - 1);
		return mp[0][0];
	} // fibo
	private static int[][] matricePotenza(int[][]m, int n) {
		if (n == 1) return m;
		if (n % 2 == 0) return Matrix.mul(matricePotenza(m, n / 2), matricePotenza(m, n / 2));
		return Matrix.mul(Matrix.mul(matricePotenza(m, n / 2), matricePotenza(m, n / 2)), m);
	} // matricePotenza
} // Mat
