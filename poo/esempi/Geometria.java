package poo.esempi;

import poo.geometria.*;

public class Geometria {
	public static void main(String[]args) {
		Punto p1 = new Punto(); // origine
		Punto p2 = new Punto(3, -7);
		System.out.println("Origine: x = " + p1.getX() + "  y = " + p1.getY());
		System.out.printf("Distanza tra " + p1 + " e " + p2 + ": %1.2f\n", p1.distanza(p2));
		p1.sposta(2, 5);
		Punto p3 = new Punto(-5, 4);
		Triangolo t = new Triangolo(p1, p2, p3);
		System.out.println(t);
		System.out.printf("Perimetro: %1.2f \n", t.perimetro());
		System.out.printf("Area: %1.2f \n", t.area());
		System.out.println("Primo vertice: " + t.getVertici()[0]);
		System.out.println("Il triangolo è " + t.tipo());
		Punto vertici[] = {new Punto(2, 3), new Punto(2, -2), new Punto(-4, -2), new Punto(-4, 3)};
		Poligono p = new Poligono(vertici);
		System.out.println(p + " | Area: " + p.area() + " | Perimetro: " + p.perimetro());
		Disco d = new Disco(p1, 6);
		System.out.println(d);
		Disco d2 = new Disco(4, 2, 8);
		System.out.println(d2 + String.format(" | Area = %1.2f | Perimetro = %1.2f", d2.area(), d2.perimetro()));
	} // main
} // Geometria
