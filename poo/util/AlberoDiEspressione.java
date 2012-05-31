package poo.util;

public class AlberoDiEspressione {
	private class Nodo {
		Nodo figlioS, figlioD;
	} // Nodo
	private class NodoOperando extends Nodo {
		int val;
	} // NodoOperando
	private class NodoOperatore extends Nodo {
		char op;
	} // NodoOperatore
	private Nodo radice = null;
	public void inFix() { inFix(radice); System.out.println(); }
	private void inFix(Nodo radice) {
		if (radice == null) return;
		if (radice instanceof NodoOperando) System.out.print(((NodoOperando)radice).val);
		else {
			System.out.print('(');
			inFix(radice.figlioS);
			System.out.print(((NodoOperatore)radice).op);
			inFix(radice.figlioD);
			System.out.print(')');
		}
	} // inFix
	// TODO
} // AlberoDiEspressione
