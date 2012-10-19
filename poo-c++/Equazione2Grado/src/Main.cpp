#include <iostream>
#include "mat.h"
#include <cmath>
#include <iomanip>

using namespace std;
using namespace mat;

int main() {
	cout << "Equazione di secondo grado" << endl;
	double a, b, c;
	cout << "a=";
	cin >> a;
	cout << "b=";
	cin >> b;
	cout << "c=";
	cin >> c;
	double discr = b * b - 4 * a * c;
	if (discr < 0) {
		cout << "Radici complesse e coniugate" << endl;
	} else if (sufficientementeProssimi(discr, 0)) {
		double x = (-b) / (2 * a);
		cout << "x1=x2=" << fixed << setprecision(2) << x << endl;
	} else {
		double x1 = (-b + sqrt(discr)) / (2 * a);
		double x2 = (-b - sqrt(discr)) / (2 * a);
		cout << "x1=" << fixed << setprecision(2) << x1 << endl;
		cout << "x2=" << fixed << setprecision(2) << x2 << endl;
	}
	return 0;
} // main
