package poo.util;

public final class Mat {
	private Mat() {}
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
