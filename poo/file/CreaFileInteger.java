package poo.file;

import java.io.*;
import java.util.*;

public class CreaFileInteger {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nome file di Oggetti Integer (serializzati) da creare: ");
		String nomeFile = sc.nextLine();
		ObjectFile<Integer> f = null;
		try {
			f = new ObjectFile<Integer>(nomeFile, ObjectFile.Modo.SCRITTURA);
			System.out.println("Inserire numeri interi (0 per terminare):");
			int x = 0;
			for (;;) {
				x = sc.nextInt();
				if (x == 0) break;
				f.put(x);
			}
		} catch (Exception e) {
			System.out.println("Errore di lettura/scrittura!");
		} finally {
			try {
				if (f != null) f.close();
			} catch (IOException e) {
				System.out.println("Errore di lettura/scrittura!");
			}
		}
	} // main	
} // CreaFileInteger
