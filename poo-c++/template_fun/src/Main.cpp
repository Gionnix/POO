#include <iostream>

using namespace std;

template <typename T> void scambia(T &a, T &b) {
	T tmp = a;
	a = b; b = tmp;
} // scambia

int main() {
	int x = 4, y = 5;
	scambia(x, y);
	cout << "x=" << x << " y=" << y << endl;
	double v = 3.5, w = 0.4;
	scambia(v, w);
	cout << "v=" << v << " w=" << w << endl;
	return 0;
} // main
