package poo.file;

import java.io.*;
import java.util.*;

public class MergeFile {
	public static void main(String[]args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Fusione ordinata di f1 e f2 su f3 (su file di oggetti Integer)");
		System.out.print("Nome primo file di interi ordinato: ");
		String nome1 = sc.nextLine();
		System.out.print("Nome secondo file di interi ordinato: ");
		String nome2 = sc.nextLine();
		System.out.print("Nome file di destinazione: ");
		String nome3 = sc.nextLine();
		ObjectFile<Integer> f1 = new ObjectFile<Integer>(nome1, ObjectFile.Modo.LETTURA);
		ObjectFile<Integer> f2 = new ObjectFile<Integer>(nome2, ObjectFile.Modo.LETTURA);
		ObjectFile<Integer> f3 = new ObjectFile<Integer>(nome3, ObjectFile.Modo.SCRITTURA);
		int x1 = 0, x2 = 0, x3 = 0; boolean first = true;
		while (!f1.eof() && !f2.eof()) {
			x1 = f1.peek(); x2 = f2.peek();
			if (x1 < x2) {
				f1.get();
				if (first || x1 != x3) { f3.put(x1); x3 = x1; }
			} else {
				f2.get();
				if (first || x2 != x3) { f3.put(x2); x3 = x2; }
			}
			first = false;
		}
		while (!f1.eof()) {
			x1 = f1.peek();
			if (x1 != x3) { f3.put(x1); f1.get(); }
		}
		while (!f2.eof()) {
			x2 = f2.peek();
			if (x2 != x3) { f3.put(x2); f2.get(); }
		}
		f1.close(); f2.close(); f3.close();
	} // main
} // MergeFile
