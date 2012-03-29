package poo.util;

public interface Vector {
	public int size();
	public int indexOf(Object o);
	public boolean contains(Object o);
	public Object get(int indice);
	public Object set(int indice, Object o);
	public void add(Object o);
	public void add(int indice, Object o);
	public void remove(Object o);
	public Object remove(int indice);
	public void clear();
	public boolean isEmpty();
	public Vector subVector(int da, int a);
} // Vector
