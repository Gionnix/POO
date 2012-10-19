#include "mat.h"
#include <cstdlib>
#include <cmath>

using namespace std;

int mcd_euclide(int n, int m) {
	if (m == 0) return n;
	return mcd_euclide(m, n % m);
} // mcd_euclide

double EPSILON = 1.0E-14;

namespace mat {

bool sufficientementeProssimi(double x1, double x2) {
	if (abs(x1 - x2) <= EPSILON) return true;
	return false;
} // sufficientementeProssimi
int mcm(int n, int m) {
	if (n <= 0 || m <= 0) exit(-1);
	return (n * m) / mcd_euclide(n, m);
} // mcm
int mcd(int n, int m) {
	if (n <= 0 || m <= 0) exit(-1);
	return mcd_euclide(n, m);
} // mcd

void setEpsilon(const double EPS) {
	EPSILON = EPS;
} // setEpsilon

double getEpsilon() {
	return EPSILON;
}//getEpsilon

}
