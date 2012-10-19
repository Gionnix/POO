#include <iostream>
#include <string>

using namespace std;

class C {
private:
	string* str;
public:
	C();
	~C();
	void f();
};

C::C() {
	this->str = new string("Java e' un'altra cosa ...");
}

C::~C() {
	cout << "Distruttore chiamato" << endl;
	delete this->str;
}

void C::f() {
	cout << *str << endl;
} // f

int main() {
	C* c = new C();
	c->f();
	delete c;
	return 0;
} // main
