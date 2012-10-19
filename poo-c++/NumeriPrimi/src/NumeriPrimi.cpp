//============================================================================
// Name        : NumeriPrimi.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : NumeriPrimi in C++, Ansi-style
//============================================================================

#include <iostream>
#include <cmath>
#include <iomanip>

using namespace std;

bool ePrimo(const unsigned int x);

int main() {
	cout << "Fornisci un intero positivo (>=2): ";
	unsigned int n;
	cin >> n;
	if (n < 2) {
		cout << "Numero errato!" << endl;
		return 0;
	}
	cout << "Numeri primi <= " << n << endl;
	int cont = 0;
	for (int x = 2; x <= n; x = (x == 2) ? x + 1 : x + 2)
		if (ePrimo(x)) {
			if (cont % 5 == 0) cout << endl;
			cont++;
			cout << setw(14) << x << " ";
		}
	cout << endl;
	return 0;
} // main

bool ePrimo(const unsigned int x) {
	if (x == 2 || x == 3) return true;
	if (x % 2 == 0) return false;
	for (int i = 3; i <= (int)(sqrt(x) + 0.5); i = i + 2)
		if (x % i == 0) return false;
	return true;
} // ePrimo
