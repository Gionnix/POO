#include <cmath>
#include "punto.h"

namespace geometria {

Punto::Punto() {
	x = 0; y=0;
} // Costruttore di default

Punto::Punto(double x, double y) {
	this->x = x; this->y = y;
} // Costruttore normale

Punto::Punto(Punto* p) {
	this->x = p->x;
	this->y = p->y;
} // Costruttore di copia

double Punto::getX() { return x; }
double Punto::getY() { return y; }

void Punto::sposta(double x, double y) {
	this->x = x; this->y = y;
} // sposta

double Punto::distanza(Punto* p) {
	return sqrt((x - p->x) * (x - p->x) + (y - p->y) * (y - p->y));
} // distanza

} // geometria
