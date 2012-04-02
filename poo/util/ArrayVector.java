package poo.util;

import java.util.*;

public class ArrayVector<T> implements Vector<T> {
	private T[] array;
	private int size;
	public ArrayVector() { this(20); }
	public ArrayVector(int length) {
		if (length <= 0) throw new IllegalArgumentException();
		array = (T[])new Object[length]; size = 0;
	} // Costruttore normale
	public int size() { return size; }
	public int indexOf(T elem) {
		for (int i = 0; i < size; i++)
			if (array[i].equals(elem)) return i;
		return -1;
	} // indexOf
	public boolean contains(T elem) {
		return indexOf(elem) != -1;
	} // contains
	public T get(int i) {
		if (i < 0 || i >= size) throw new IllegalArgumentException();
		return array[i];
	} // get
	public T set(int i, T elem) {
		if (i < 0 || i >= size) throw new IllegalArgumentException();
		T oldElem = array[i];
		array[i] = elem;
		return oldElem;
	} // set
	public void add(T elem) {
		if (size == array.length) espandi();
		array[size++] = elem;
	} // add
	private void espandi() {
		array = Arrays.copyOf(array, array.length * 2);
	} // espandi
	public void add(int i, T elem) {
		if (i < 0 || i > size) throw new IndexOutOfBoundsException();
		if (size == array.length) espandi();
		for (int j = size - 1; j >= i; j--)
			array[j + 1] = array[j];
		array[i] = elem;
		size++;
	} // add
	public void remove(T elem) {
		int i = indexOf(elem);
		if (i == -1) return;
		remove(i);
	} // remove
	public T remove(int i) {
		if (i < 0 || i >= size) throw new IndexOutOfBoundsException();
		T elem = array[i];
		for (int j = i + 1; j < size; j++)
			array[j - 1] = array[j];
		array[--size] = null;
		if (size < array.length / 2) contrai();
		return elem;
	} // remove
	private void contrai() {
		array = Arrays.copyOf(array, array.length / 2);
	} // contrai
	public void clear() {
		for (int i = 0; i < size; i++)
			array[i] = null;
		size = 0;
	} // clear
	public boolean isEmpty() { return size == 0; }
	public Vector<T> subVector(int da, int a) {
		if (da < 0 || da >= size || a < 0 || a > size || da >= a)
			throw new RuntimeException();
		Vector<T> v = new ArrayVector(a - da);
		for (int j = da; j < 0; j++)
			v.add(array[j]);
		return v;
	} // subVector
	public String toString() {
		StringBuilder sb = new StringBuilder(size * 15);
		sb.append('[');
		for (int i = 0; i < size; i++) {
			sb.append(array[i]);
			if (i < size - 1) sb.append(", ");
		}
		sb.append(']');
		return sb.toString();
	} // toString
	public boolean equals(Object o) {
		if (!(o instanceof Vector)) return false;
		if (o == this) return true;
		Vector<T> v = (Vector<T>)o;
		if (size != v.size()) return false;
		for (int i = 0; i < size; i++)
			if (!array[i].equals(v.get(i))) return false;
		return true;
	} // equals
	public int hashCode() {
		return Arrays.hashCode(array);
	} // hashCode
} // ArrayVector<T>
