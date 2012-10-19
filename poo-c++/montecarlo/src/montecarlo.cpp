/*
 * Esempio di simulazione numerica Monte Carlo.
 * Approssima il valore di pi-greco contando
 * quante volte un numero casuale tra -1 e 1
 * ricade dentro un cerco di raggio unitario, centrato
 * nell'origine e inscritto in un quadrato di lato 2.
 * L'area del cerchio è pi, quella del quadrato e' 4.
 * Il rapporto pi/4 approssimativamente e' uguale
 * al rapporto tra numero dei tiri dentro il cerchio e
 * numero dei tiri nel quadrato.
 */
#include <iostream>
#include <cstdlib>
#include <cmath>
#include <ctime>

using namespace std;

int main() {
	const int TIRI = 100000;
	srand(time(0));
	int aSegno = 0; // Tiri dentro il cerchio
	for (int i = 0; i < TIRI; i++) {
		double r = (rand() * 1.0) / RAND_MAX; // r è tra 0 e d 1
		double x = -1 + 2 * r; // x tra -1 ed 1
		r = rand() * 1.0 / RAND_MAX;
		double y = -1 + 2 * r; // y tra -1 ed 1
		if (x * x + y * y <= 1) aSegno++;
	}
	double stimaPI = 4.0 * aSegno / TIRI;
	cout << "Stima di PI greco =" << stimaPI << endl;
	return 0;
} // main
