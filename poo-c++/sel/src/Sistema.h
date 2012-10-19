/*
 * Sistema.h
 *
 *  Created on: 15-apr-2009
 *      Author: Libero Nigro
 */

#ifndef SISTEMA_H_
#define SISTEMA_H_

namespace sistema {
	const int SISTEMA_SINGOLARE = 20;

	class Sistema {
	private:
		int n;
	public:
		int getN() { return n; };
		Sistema(double* a[], double y[], int n) {
			this->n = n;
		}
		virtual double* risolvi() = 0;
	};
} // sistema

#endif /* SISTEMA_H_ */
