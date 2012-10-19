/*
 * Gauss.h
 *
 *  Created on: 15-apr-2009
 *      Author: Libero Nigro
 */

#ifndef GAUSS_H_
#define GAUSS_H_
#include "Sistema.h"

namespace sistema {

	class Gauss : public Sistema {
	private:
		double** a;
	public:
		Gauss(double* a[], double* y, int n);
		virtual ~Gauss();
		virtual double* risolvi();
	protected:
		virtual void triangolazione();
		virtual double* calcoloSoluzione();
	};

} // sistema

#endif /* GAUSS_H_ */
