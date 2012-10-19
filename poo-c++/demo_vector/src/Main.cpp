#include <iostream>
#include <vector>

using namespace std;

int main() {
	vector<int> v; //oggetto sullo stack di dimensione 0
	v.push_back(10);
	v.push_back(20);
	v.push_back(30);
	v.push_back(40);
	for (unsigned int i = 0; i < v.size(); i++)
		cout << "v[" << i << "]=" << v[i];
	cout << endl;
	v.erase(v.begin(), v.begin() + 2);
	for (unsigned int i = 0; i < v.size(); i++)
		cout << "v[" << i << "]=" << v[i];
	cout << endl;
	return 0;
} // main
