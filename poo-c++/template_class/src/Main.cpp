#include <iostream>
#include <vector>

using namespace std;

template <class T>
class Coda {
     vector<T> vect;
public:
     virtual void add(T const &);
     virtual T remove();
     virtual void print();
};

template <typename T> void Coda<T>::add(T const &d) {
	vect.push_back(d);
} // add

template <typename T> T Coda<T>::remove() {
	T x = vect[0];
	vect.erase(vect.begin(), vect.begin() + 1);
	return x;
} // remove

template <typename T> void Coda<T>::print() {
	for (unsigned int i = 0; i < vect.size(); i++)
		cout << " " << vect[i] << endl;
} // print

int main() {
	Coda<int>* q = new Coda<int>;
	q->add(10);
	q->add(20);
	q->add(30);
	cout << "Prima della rimozione " << endl;
	q->print();
	int x = q->remove();
	cout << "Dopo la rimozione " << endl;
	q->print();
	cout << "x=" << x << endl;
	return 0;
} // main
