#include <fstream>
#include <iostream>
#include <cctype>
#include <cstdlib>

using namespace std;

int main() {
	cout << "Nome file sorgente: ";
	string sorg;
	getline(cin, sorg);
	ifstream in_file;
	in_file.open(sorg.c_str());
	if (in_file.fail()) {
		cout << "File sorgente inesistente!" << endl;
		exit(-1);
	}
	cout << "nome file destinazione: ";
	string dest;
	getline(cin, dest);
	ofstream out_file;
	out_file.open(dest.c_str());
	cout << "Contenuto file sorgente" << endl;
	while (!in_file.fail()) {
		string linea;
		getline(in_file, linea);
		cout << linea << endl;
		for (unsigned int i = 0; i < linea.length(); i++)
			linea[i] = toupper(linea[i]);
		out_file << linea << endl;
	}
	in_file.close();
	out_file.close();
	return 0;
} // main
