#include <cmath>
#include <iostream>
#include <typeinfo>
#include "punto.h"
#include "cerchio.h"

using namespace std;
using namespace geometria;

int main() {
	Punto* p0 = new Punto; // Costruttore di default
	Punto* p1 = new Punto(3,4); // Costruttore normale
	double d = p0->distanza(p1);
	cout << "distanza: " << d << endl;
	Cerchio* c = new Cerchio(4);
	c->sposta(4,5);
	d = p1->distanza(c);
	double ar = c->area();
	double pr = c->perimetro();
	cout << "distanza q-c: " << d << endl;
	cout << "area: " << ar << endl;
	cout << "perimetro: " << pr << endl;
	Punto* p = c;
	if (typeid(*p) == typeid(Cerchio)) {
		Cerchio* cc = dynamic_cast<Cerchio*>(p);
		cout << "raggio: " << cc->getRaggio() << endl;
	}
	return 0;
} // main
