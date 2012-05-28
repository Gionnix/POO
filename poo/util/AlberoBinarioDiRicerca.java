package poo.util;

import java.util.*;

public class AlberoBinarioDiRicerca<T extends Comparable<? super T>> extends CollezioneOrdinataAstratta<T> {
	private static class Albero<E> {
		E info;
		Albero<E> figlioSinistro, figlioDestro;
	} // Albero
	private Albero<T> radice = null;

	public int size() { return size(radice); }
	private int size(Albero<T> radice) {
		if (radice == null) return 0;
		return 1 + size(radice.figlioSinistro) + size(radice.figlioDestro);
	} // size

	public boolean contains(T elem) { return contains(radice, elem); }
	private boolean contains(Albero<T> radice, T elem) {
		if (radice == null) return false;
		if (radice.info.equals(elem)) return true;
		if (radice.info.compareTo(elem) > 0)
			return contains(radice.figlioSinistro, elem);
		return contains(radice.figlioDestro, elem);
	} // contains

	public T get(T elem) { return get(radice, elem); }
	private T get(Albero<T> radice, T elem) {
		if (radice == null) return null;
		if (radice.info.equals(elem)) return radice.info;
		if (radice.info.compareTo(elem) > 0)
			return get(radice.figlioSinistro, elem);
		return get(radice.figlioDestro, elem);
	} // get

	public void clear() { radice = null; }
	public boolean isEmpty() { return radice == null; }
	public boolean isFull() { return false; }

	public void add(T elem) { radice = add(radice, elem); }
	private Albero<T> add(Albero<T> radice, T elem) {
		if (radice == null) {
			radice = new Albero<T>();
			radice.info = elem;
		} else if (radice.info.compareTo(elem) > 0)
			radice.figlioSinistro = add(radice.figlioSinistro, elem);
		else
			radice.figlioDestro = add(radice.figlioDestro, elem);
		return radice;
	} // add


	public void remove(T elem) { radice = remove(radice, elem); }
	private Albero<T> remove(Albero<T> radice, T elem) {
		if (radice == null) return null;
		if (radice.info.compareTo(elem) > 0)
			radice.figlioSinistro = remove(radice.figlioSinistro, elem);
		else if (radice.info.compareTo(elem) < 0)
			radice.figlioDestro = remove(radice.figlioDestro, elem);
		else { // radice.info.equals(elem)
			if (radice.figlioSinistro == null) radice = radice.figlioDestro;
			else if (radice.figlioDestro == null) radice = radice.figlioSinistro;
			else {
				Albero<T> padre = radice;
				Albero<T> figlio = radice.figlioSinistro; // Ricerca elemento più a destra nel sottoalbero sinistro
				while (figlio.figlioDestro != null) {
					padre = figlio;
					figlio = figlio.figlioDestro;
				}
				radice.info = figlio.info; // Trovato
				if (padre == radice) padre.figlioSinistro = figlio.figlioSinistro;
				else padre.figlioDestro = figlio.figlioSinistro;
			}
		}
		return radice;
	} // remove

	@SuppressWarnings("unchecked")
	public boolean equals(Object o) {
		if (!(o instanceof AlberoBinarioDiRicerca)) return false;
		if (o == this) return true;
		return equals(this.radice, ((AlberoBinarioDiRicerca)o).radice);
	} // equals
	private boolean equals(Albero<T> a1, Albero<T> a2) {
		if (a1 == null && a2 == null) return true;
		if (a1 == null || a2 == null) return false;
		if (!a1.info.equals(a2.info)) return false;
		return equals(a1.figlioSinistro, a2.figlioSinistro) && equals(a1.figlioDestro, a2.figlioDestro);
	} // equals

	public String toString(){
		StringBuilder sb=new StringBuilder(200);
		sb.append('[');
		toString(radice, sb);
		if (sb.charAt(sb.length() - 1) == ' ') sb.setLength(sb.length() - 2);
		sb.append(']');
		return sb.toString();
	} // toString
	private void toString(Albero<T> radice, StringBuilder sb) {
		if (radice == null) return;
		toString(radice.figlioSinistro, sb);
		sb.append(radice.info); sb.append(", ");
		toString(radice.figlioDestro, sb);
	} // toString

	public int hashCode() { return hashCode(radice); }
	private int hashCode(Albero<T> radice) {
		final int MOLT = 43;
		if (radice == null) return 0;
		return radice.info.hashCode() * MOLT + hashCode(radice.figlioSinistro) + hashCode(radice.figlioDestro);
	} // hashCode

	public void visitaSimmetrica() { visitaSimmetrica(radice); }
	private void visitaSimmetrica(Albero<T> radice) {
		if (radice != null) {
			visitaSimmetrica(radice.figlioSinistro);
			System.out.print(radice.info + " ");
			visitaSimmetrica(radice.figlioDestro);
		}
	} // visitaSimmetrica

	public void visitaSimmetrica(List<T> l) { visitaSimmetrica(radice, l); }
	private void visitaSimmetrica(Albero<T> radice, List<T> l) {
		if (radice != null) {
			visitaSimmetrica(radice.figlioSinistro, l);
			l.add(radice.info);
			visitaSimmetrica(radice.figlioDestro, l);
		}
	} // visitaSimmetrica

	public boolean bilanciato() { return bilanciato(radice); }
	private boolean bilanciato(Albero<T> albero) {
		if (albero == null) return true;
		if (Math.abs(size(albero.figlioSinistro) - size(albero.figlioDestro)) > 1) return false;
		return bilanciato(albero.figlioSinistro) && bilanciato(albero.figlioDestro);
	} // bilanciato
	
	public Iterator<T> iterator() {
		return new ABRIterator();
	} // iterator
	private class ABRIterator implements Iterator<T> {
		private Albero<T> cur = null; private boolean rimovibile = false;
		private Stack<Albero<T>> nodi = new StackConcatenato<Albero<T>>();
		public boolean hasNext() {
			if (cur == null) return radice != null;
			return !nodi.isEmpty();
		} // hasNext
		public T next() {
			if (!hasNext()) throw new NoSuchElementException();
			if (cur == null) {
				cur = radice;
				while (cur.figlioSinistro != null) {
					nodi.push(cur); cur = cur.figlioSinistro;
				}
			} else {
				cur = nodi.pop();
				if (cur.figlioDestro != null) {
					Albero<T> figlio = cur.figlioDestro;
					do nodi.push(figlio);
					while ((figlio = figlio.figlioSinistro) != null);
				}
			}
			rimovibile = true;
			return cur.info;
		} // next
		public void remove() {
			return; // TODO
		} // remove
	} // ABRIterator
	public static void main(String[]args) {
		AlberoBinarioDiRicerca<Integer> abr = new AlberoBinarioDiRicerca<Integer>();
		abr.add(4); abr.add(12); abr.add(-7); abr.add(15);
		abr.add(2); abr.add(1); abr.add(3); abr.add(-8);
		abr.add(-2); abr.add(10); abr.add(-1); abr.add(25);
		abr.add(-19); abr.add(7); abr.add(15); abr.add(0);
		System.out.println(abr);
		System.out.println("size = " + abr.size());
		System.out.println("Test iteratore");
		for (int n: abr) System.out.println(n + " ");
		System.out.println("abr contains 15: " + abr.contains(15));
		int r = 10;
		System.out.println("Test rimozione di " + r);
		abr.remove(r);
		System.out.println(abr);
		System.out.println("Visita Simmetrica");
		abr.visitaSimmetrica();
		System.out.println();
		r = -7;
		System.out.println("Test rimozione di " + r);
		abr.remove(r);
		System.out.println(abr);
	} // main
} // AlberoBinarioDiRicerca
