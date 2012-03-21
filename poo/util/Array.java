package poo.util;

public final class Array {
	private Array() {}
	public static void selectionSort(Comparable[]v) {
		for (int j = v.length - 1; j > 0; j--) {
			int imax = 0;
			for (int i = 1; i <= j; i++)
				if (v[i].compareTo(v[imax]) >= 0)
					imax = i;
			Comparable tmp = v[j];
			v[j] = v[imax];
			v[imax] = tmp;
		}
	}
}
