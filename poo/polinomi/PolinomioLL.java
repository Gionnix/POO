package poo.polinomi;

import java.util.*;

public class PolinomioLL extends PolinomioAstratto {
	private LinkedList<Monomio> elenco = new LinkedList<Monomio>();
	public int size() { return elenco.size(); }
	@Override protected PolinomioLL crea() {
		return new PolinomioLL();
	} // crea
	public void add(Monomio m) {
		ListIterator<Monomio> li = elenco.listIterator();
		while (li.hasNext()) {
			Monomio m1 = li.next();
			if (m1.equals(m)) {
				Monomio somma = m1.add(m);
				if (somma.getCoeff() == 0) li.remove();
				else li.set(somma); return;
			} else if (m1.compareTo(m) > 0) {
				li.previous(); li.add(m); return;
			}
		}
		li.add(m);
	} // add
	public Iterator<Monomio> iterator() {
		return elenco.iterator();
	} // iterator
} // PolinomioAstratto
