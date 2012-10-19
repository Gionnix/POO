#ifndef PUNTO_H_
#define PUNTO_H_

namespace geometria {

class Punto {
	private:
		double x, y;
	public:
		Punto();
		Punto(double x, double y);
		Punto(Punto* p);
		virtual double getX();
		virtual double getY();
		virtual void sposta(double x, double y);
		virtual double distanza(Punto* p);
}; // Punto

} // geometria

#endif /* PUNTO_H_ */
