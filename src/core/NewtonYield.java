package core;

/**
Copyright (C) 2013 QuantFish.com

This source code is released under the Artistic License 2.0.

Code license: http://www.opensource.org/licenses/artistic-license-2.0.php

*/

public class NewtonYield extends NewtonRaphson
{
	public NewtonYield(double initialval, double precision,
	int iterations ) {
		inputvalue=initialval;
		iteration=iterations;
		prec=precision;
	}
	
	//protected double nominal stock price;
	protected double nominalpricevalue;
	protected double termperiod;
	protected double couponrate;
	protected double marketpricevalue;
	protected double inputvalue;
	protected double rateperTerm;
	protected double maturityperiod;
	protected double rateindex;
	int iteration;
	double prec;
	
	public double newtonroot(double rootinput)
	//implements the abstract method from interval bisection
	{
		double poscashflow,solution;
		poscashflow=rateperTerm;//cashflow out per term as monthly
		//amount * termperiod//
		solution=(poscashflow/rootinput*(1.0-1.0/(Math.pow(1.0+rootinput,rateindex))))+(nominalpricevalue/
		(Math.pow(1.0+rootinput, rateindex)))-marketpricevalue;
		return solution;
	}
	
	public double yield(double noms, double term, double coupon,
	double mktp, double period) {
		nominalpricevalue=noms;
		termperiod=term;
		couponrate=coupon;
		marketpricevalue=mktp;
		rateperTerm=((coupon/term));
		maturityperiod=period;
		rateindex=(maturityperiod*term);
		accuracy(prec,iteration);
		return newtraph(inputvalue);
	}

}

