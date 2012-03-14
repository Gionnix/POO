package poo.util;

public final class Mat {
	private static double EPSILON = 1.0E-14;
	private Mat() {}
	public static getEpsilon() { return EPSILON; }
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
} // Mat
