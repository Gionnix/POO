package poo.heap;

import java.util.*;

public class Heap<T extends Comparable<? super T>> implements Iterable<T> {
	private T[] heap;
	private int n, size;
	private Comparator<T> c;
	public Heap(int n) {
		this(n, new Comparator<T>() { // Default: natural sorting
			public int compare(T a, T b) { return a.compareTo(b); }
		});
	} // Costruttore
	@SuppressWarnings("unchecked")
	public Heap(int n, Comparator<T> c) {
		if (n <= 0) throw new IllegalArgumentException();
		this.n = n; size = 0;
		heap = (T[])new Comparable[n + 1];
		this.c = c;
	} // Costruttore 2
	public int size() { return size; }
	public void clear() {
		for (int i = 1; i <= size; i++)
			heap[i] = null;
		size = 0;
	} // clear
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
			if (c.compare(heap[i], heap[i / 2]) < 0) {
				T tmp = heap[i];
				heap[i] = heap[i / 2];
				heap[i / 2] = tmp;
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
			if (k + 1 <= size && c.compare(heap[k + 1], heap[k]) < 0) k++; // minimo
			if (c.compare(heap[i], heap[k]) > 0) {
				T tmp = heap[i]; heap[i] = heap[k];
				heap[k] = tmp; i = k;
			} else break;
		}
		return min;
	} // remove
	public String toString() {
		StringBuilder sb = new StringBuilder(200);
		sb.append('[');
		for (int i = 1; i <= size; i++)
			sb.append(heap[i] + (i == size ? "" : ", "));
		sb.append(']');
		return sb.toString();
	} // toString
	public int hashCode() {
		final int MOLT = 811; int h = 0;
		for (int i = 1; i <= size; i++)
			h = h * MOLT + heap[i].hashCode();
		return h;
	} // hashCode
	@SuppressWarnings("unchecked")
	public boolean equals(Object o) {
		if (!(o instanceof Heap)) return false;
		if (o == this) return true;
		Heap<T> h = (Heap)o;
		if (size != h.size) return false;
		for (int i = 1; i <= size; i++)
			if (!heap[i].equals(h.heap[i])) return false;
		return true;
	} // equals
	public Iterator<T> iterator() {
		return new HeapIterator();
	} // iterator
	private class HeapIterator implements Iterator<T> {
		int corrente = 0; public boolean rimovibile = false;
		public boolean hasNext() {
			return corrente < size;
		} // hasNext
		public T next() {
			if (!hasNext()) throw new NoSuchElementException();
			rimovibile = true;
			return heap[++corrente];
		} // next
		@SuppressWarnings("unchecked")
		public void remove() {
			if (!rimovibile) throw new IllegalStateException();
			rimovibile = false;
			heap[corrente] = null; int pos = 0;
			T[] tmp = (T[])new Comparable[size - corrente];
			for (int i = corrente + 1; i <= size; i++) {
				tmp[pos++] = heap[i]; heap[i] = null;
			}
			size = --corrente;
			for (int i = 0; i < pos; i++) add(tmp[i]);
		} // remove
	} // HeapIterator
} // Heap
