package poo.esempi;

import poo.data.Data;

public class TestData {
	public static void main(String[]args) {
		Data today = new Data();
		System.out.println("Data attuale: " + today);
		System.out.println("L'anno " + today.getA() + (Data.bisestile(today.getA()) ? " " : " non ") + "è bisestile");
		Data d = new Data(29, 2, 2012);
		System.out.println("Giorno successivo al " + d + ": " + d.giornoDopo());
	} // main
} // TestData
