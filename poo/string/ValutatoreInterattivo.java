package poo.string;

import java.util.*;

public class ValutatoreInterattivo {
	static StringTokenizer st = null;
	static int valuta(int level) {
		int v, opnd; char op;
		String tk = st.nextToken();
		if (tk.equals(")")) throw new BadSyntaxException();
		else if (tk.equals("(")) v = valuta(level+1);
		else v = Integer.parseInt(tk);
		while (st.hasMoreTokens()) {
			tk = st.nextToken();
			if (tk.equals(")"))
				if (level == 0) throw new BadSyntaxException();
				else return v;
			else op = tk.charAt(0);
			tk = st.nextToken();
			if (tk.equals("(")) opnd = valuta(level+1);
			else opnd = Integer.parseInt(tk);
			switch(op) {
				case '+': v += opnd; break;
				case '-': v -= opnd; break;
				case '*': v *= opnd; break;
				default: v /= opnd; break;
			}
		}
		if (level > 0) throw new BadSyntaxException();
		return v;
	} // valuta
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(	"Valutatore interattivo di espressioni matematiche\n" +
					"Supporta gli operatori '+', '-', '*' e '/'. \n" +
					"Utilizzare le tonde () per la precedenza degli operatori.\n" +
					"Digitare '.' (punto) su una riga vuota per uscire."		);
		for (;;) {
			System.out.print("> ");
			String linea = sc.nextLine();
			if (linea.equals(".")) break;
			st = new StringTokenizer(linea, "+-*/()", true);
			try {
				System.out.println(linea + " = " + valuta(0));
			} catch (NumberFormatException e) {
				System.out.println("L'espressione inserita contiene caratteri non validi!");
			} catch (NoSuchElementException e) {
				System.out.println("Operando mancante!");
			} catch (BadSyntaxException e) {
				System.out.println("Sintassi parentesi errata!");
			}
		}
		System.out.println("Bye!");
	} // main
} // ValutatoreInterattivo
