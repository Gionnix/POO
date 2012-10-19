/*
 * Main.cpp
 *
 *  Updated on: 10-giu-2012
 *      Author: Libero Nigro
 */
#include <iostream>
#include <exception>
#include <iomanip>
#include <cstdlib>
#include "Gauss.h"
#include "Sistema.h"

using namespace std;
using namespace sistema;

int main() {
	cout << "Risoluzione di un Sistema di Equazioni Lineari col metodo di GAUSS" << endl;
	cout << "Dimensione del sistema (>=1): ";
	int n;
	cin >> n;
	if (n <= 0) {
		cout << "Dimensione del sistema errata" << endl;
		exit(-1);
	}
	double** a = new double*[n];
	for (int i = 0; i < n; i++) a[i] = new double[n];
	double* y = new double[n];
	double* x = NULL;
	// Lettura matrice
	cout << "Fornisci " << n << "x" << n << " elementi della matrice a per righe" << endl;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++) {
			cout << "a[" << i << "," << j << "]=";
			double d;
			cin >> d;
			a[i][j] = d;
		}
	cout << endl;
	cout << endl;
	cout << "Fornisci " << n << " termini noti" << endl;
	for (int i = 0; i < n; i++) {
		cout << "y[" << i << "]=";
		cin >> y[i];
	}
	Sistema* s;
	try {
		s = new Gauss(a, y, n);
		x = s->risolvi();
	} catch(int e) {
		switch(e) {
		case SISTEMA_SINGOLARE:
			cout << "Sistema Singolare!" << endl;
		}
		exit(-1);
	}
	// Scrivi risultati
	cout << "Vettore delle incognite" << endl;
	for (int i = 0; i < n; i++)
		cout << "x[" << i << "]=" << fixed << setprecision(2) << x[i] << endl;
	return 0;
} // main
