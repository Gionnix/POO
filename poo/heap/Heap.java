package poo.heap;

public class Heap<T extends Comparable<? super T>> {
	private T[] heap;
	private int n, size;
	@SuppressWarnings("unchecked")
	public Heap(int n) {
		if (n <= 0) throw new IllegalArgumentException();
		this.n = n; size = 0;
		heap = (T[])new Comparable[n + 1];
	} // Costruttore
	public int size() { return size; }
	public boolean contains(T elem) {
		for (int i = 1; i <= size; i++)
			if (heap[i].equals(elem)) return true;
		return false;
	} // contains
	public void add(T elem) {
		if (size == n) {
			heap = java.util.Arrays.copyOf(heap, 2 * n + 1);
			n = 2 * n;
		}
		heap[++size] = elem;
		int i = size;
		while (i > 1) {
			if (heap[i].compareTo(heap[i / 2]) < 0) {
				T tmp = heap[i];
				heap[i] = heap[i / 2];
				heap[i / 2] = heap[i];
				i = i / 2;
			} else break;
		}
	} // add
	public T remove() {
		if (size == 0) throw new RuntimeException("Empty Heap!");
		T min = heap[1]; heap[1] = heap[size];
		heap[size--] = null;
		int i = 1;
		while (i <= size / 2) {
			int j = 2 * i, k = j;
			if (k + 1 <= size && heap[k + 1].compareTo(heap[k]) < 0) k++; // minimo
			if (heap[i].compareTo(heap[k]) > 0) {
				T tmp = heap[i]; heap[i] = heap[k];
				heap[k] = tmp; i = k;
			} else break;
		}
		return min;
	} // remove
} // Heap
