package poo.esempi;

import poo.data.Data;

public class TestData {
	public static void main(String[]args) {
		Data today = new Data();
		System.out.println("Data attuale: " + today);
		System.out.println("L'anno " + today.get(Data.Elemento.ANNO) + (Data.bisestile(today.get(Data.Elemento.ANNO)) ? " " : " non ") + "è bisestile");
		Data d = new Data(29, 2, 2012);
		System.out.println("Giorno successivo al " + d + ": " + d.giornoDopo());
		Data d1 = new Data(1, 3, 2012);
		System.out.println("Giorni trascorsi tra " + d + " e " + d1 + ": " + d1.distanza(d));
	} // main
} // TestData
