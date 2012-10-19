#ifndef CERCHIO_H_
#define CERCHIO_H_

#include "punto.h"

namespace geometria {

class Cerchio : public Punto {
	private:
		double raggio;
	public:
		Cerchio(double raggio);
		Cerchio(double x, double y, double raggio);
		Cerchio(Punto* p, double raggio);
		Cerchio(Cerchio* c);
		virtual double getRaggio();
		virtual double perimetro();
		virtual double area();
};

} // geometria

#endif /* CERCHIO_H_ */
