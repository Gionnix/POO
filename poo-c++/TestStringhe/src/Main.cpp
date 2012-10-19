#include <iostream>
#include <string>
#include <cctype>

using namespace std;

int main() {
	string linea;
	cout << "Fornisci cognome e nome: ";
	getline(cin, linea); // Legge cognome e nome di una persona
	cout << linea.length() << endl;
	int i = 0;
	while (i < linea.length()) // Salta spazi che precedono il cognome
		if (linea[i] != ' ') break;
		else i++;
	int k = i;
	while (i < linea.length() && linea[i] != ' ') // Trova primo spazio dopo cognome
		i++;
	string cognome = linea.substr(k, i - k);
	while (i < linea.length() && linea[i] == ' ') // Salta spazi prima di nome
		i++;
	string nome = linea.substr(i);
	cout << "cognome: " << cognome << endl;
	cout << "nome: " << nome << endl;
	for (int j = 0; j < nome.length(); j++)
		nome[j] = toupper(nome[j]);
	cout << "nome: " << nome << endl;
	return 0;
} // main
