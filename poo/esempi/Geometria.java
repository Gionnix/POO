package poo.esempi;

import poo.geometria.*;

public class Geometria {
	public static void main(String[]args) {
		Punto p1 = new Punto(); // origine
		Punto p2 = new Punto(3, -7);
		double d12 = p1.distanza(p2); // = p2.distanza(p1);
		System.out.println("x: " + p1.getX() + "  y: " + p1.getY());
		p1.sposta(2, 5);
		System.out.println(p1.toString()); // o System.out.println(p1);
		System.out.println(p2);
		System.out.println("Distanza: " + d12);
		Punto p3 = new Punto(-5, 4);
		Triangolo t = new Triangolo(p1, p2, p3);
		System.out.println("Triangolo: " + t);
		System.out.printf("Perimetro: %1.2f \n", t.perimetro());
		System.out.printf("Area: %1.2f \n", t.area());
		System.out.println("Primo vertice: " + t.getVertici()[0]);
		Punto vertici[] = {new Punto(2, 3), new Punto(2, -2), new Punto(-4, -2), new Punto(-4, 3)};
		Poligono p = new Poligono(vertici);
		System.out.println("Poligono formato dai vertici: " + p + "\n Area: " + p.area() + " | Perimetro: " + p.perimetro());
	} // main
} // Geometria
