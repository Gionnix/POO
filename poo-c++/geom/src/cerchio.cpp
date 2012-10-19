#include "cerchio.h"

const double PI = 3.14159;

namespace geometria {
	Cerchio::Cerchio(double raggio) : Punto() {
		this->raggio = raggio;
	}
	Cerchio::Cerchio(double x, double y, double raggio) : Punto(x,y) {
		this->raggio = raggio;
	}
	Cerchio::Cerchio(Punto* p, double raggio) : Punto(p) {
		this->raggio = raggio;
	}
	Cerchio::Cerchio(Cerchio* c) : Punto(c->getX(), c->getY()) {
		this->raggio = c->raggio;
	}
	double Cerchio::getRaggio() {
		return raggio;
	} // getRaggio
	double Cerchio::perimetro(){
		return 2 * PI * raggio;
	} // perimetro
	double Cerchio::area() {
		return raggio * raggio * PI;
	} // area
} // namespace
