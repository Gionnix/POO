#include <iostream>

using namespace std;

void foo(int x, int &y, int a[], int n) {
    y += x - 1;
    for (int i = 0; i < n; i++)
          a[i] = x * i - y;
} // foo

int main() {
	int v[10]; // v è sullo stack
	int a = 7, b = 9;
	foo(a + 2, b, v, 10);
	cout << "a=" << a << " b=" << b << endl;
	for (int i = 0; i < 10; i++) cout << v[i] << " ";
	cout << endl;
	return 0;
}
