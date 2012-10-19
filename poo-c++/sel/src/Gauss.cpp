#include "Gauss.h"
#include "mat.h"
#include <exception>
#include <iostream>

using namespace std;
using namespace mat;

namespace sistema {

	Gauss::Gauss(double* a[], double* y, int n) : Sistema(a, y, n) {
		this->a = new double*[n];
		for (int i = 0; i < n; i++)
			this->a[i] = new double[n+1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				this->a[i][j] = a[i][j];
			this->a[i][n] = y[i];
		}
	} // Costruttore

	Gauss::~Gauss() {
		for (int i = 0; i < this->getN(); i++)
			delete[] a[i];
	} // Distruttore

	void Gauss::triangolazione() {
		// Rende "a" triangolare superiore
		int n = this->getN();
		for (int j = 0; j < n; j++) {
			if (sufficientementeProssimi(a[j][j], 0)) {
				int p = j+1;
				for ( ; p < n; p++)
					if (!sufficientementeProssimi(a[p][j], 0)) break;
				if (p == n) throw SISTEMA_SINGOLARE;
				// Scambia riga p con riga j
				// Si scambiano direttamente i vettori righe p e j
				double* tmp = a[j];
				a[j] = a[p]; a[p] = tmp;
			}
			// Azzera elementi sulla colonna j, dalla riga (j+1)-esima all'ultima
			for (int i = j + 1; i < n; i++) {
				if (!sufficientementeProssimi(a[i][j], 0)) {
					double coeff = a[i][j] / a[j][j];
					// Sottrai dalla riga i-esima la riga j-esima moltip per coeff
					for (int k = j; k < n + 1; k++)
						a[i][k] -= a[j][k] * coeff;
				}
			}
		} // for esterno su j
	} // triangolarizza

	double* Gauss::calcoloSoluzione() {
		// "a" è triangolare superiore
		int n = this->getN();
		double* x = new double[n];
		for (int i = n - 1; i >= 0; i--) {
			double sm = a[i][n];
			for (int j = i + 1; j < n; j++)
				sm -= a[i][j] * x[j];
			x[i] = sm / a[i][i];
		}
		return x;
	} // calcoloSoluzione

	double* Gauss::risolvi() {
		triangolazione();
		return calcoloSoluzione();
	} // risolvi

} // namespace sistema
