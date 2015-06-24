package beans;

import options.BlackScholes;

public class BSOptionPricing {
	
	public static double spotPrice = 0.0;
	public static double strikePrice = 0.0;
	public static double riskFreeRate = 0.0;
	public static double currentpriceC = 0.0;
	//public static double currentpriceP = 0.0;
	public static double monthsToExpiry = 0.0;
	public static double volatility = 0.0;
	public static String validation1 = "";
	public static String validation2 = "";
	
	// public static boolean isCall;

	public static String getValidation1() {
		return validation1;
	}

	public static void setValidation1(String validation1) {
		BSOptionPricing.validation1 = validation1;
	}

	public static String getValidation2() {
		return validation2;
	}

	public static void setValidation2(String validation2) {
		BSOptionPricing.validation2 = validation2;
	}

	double gamma;
	double deltaCall;
	double thetaCall;
	double rhoCall;
	double deltaPut;
	double thetaPut;
	double rhoPut;

	int i = 1;

	public void doCalc() {
		double sprice = spotPrice;
		double strike = strikePrice;
		double volatility = BSOptionPricing.volatility;
		double time = monthsToExpiry;
		double rate = riskFreeRate;
		double carryrate = rate;
		BlackScholes BS = new BlackScholes(carryrate);
		//for (i = 1; i < 10; i++) {
			BS.bscholEprice(sprice, strike, volatility, time, rate);
			currentpriceC = BS.getCalle();
		//	currentpriceP = BS.getPute();
		//	gamma = BS.getGamma();
		//	deltaCall = BS.getDeltac();
		//	thetaCall = BS.getThetac();
		//	rhoCall = BS.getRhoc();
		//	deltaPut = BS.getDeltap();
		//	thetaPut = BS.getThetap();
		//	rhoPut = BS.getRhop();
	//		sprice++;
			
			System.out.println("The spot price is: £"
					+ sprice
					+ ". So one call option will cost: £"
					+ currentpriceC + "\n");
		}
//	}

	public BSOptionPricing(double spotPrice, double strikePrice,
			double riskFreeRate, double currentpriceC,
			double monthsToExpiry, double volatility) {

		BSOptionPricing.spotPrice = spotPrice;
		BSOptionPricing.strikePrice = strikePrice;
		BSOptionPricing.riskFreeRate = riskFreeRate;
		BSOptionPricing.currentpriceC = currentpriceC;
		BSOptionPricing.monthsToExpiry = monthsToExpiry;
		BSOptionPricing.volatility = volatility;
	}
	
	// default constructor
		public BSOptionPricing() {	
		}
		

	public static double getSpotPrice() {
		return spotPrice;
	}

	public void setSpotPrice(double spotPrice) {
		BSOptionPricing.spotPrice = spotPrice;
	}

	public double getStrikePrice() {
		return strikePrice;
	}

	public void setStrikePrice(double strikePrice) {
		BSOptionPricing.strikePrice = strikePrice;
	}

	public double getRiskFreeRate() {
		return riskFreeRate;
	}

	public static double getCurrentpriceC() {
		return currentpriceC;
	}

	public void setCurrentpriceC(double currentpriceC) {
		BSOptionPricing.currentpriceC = currentpriceC;
	}

/*	public double getCurrentpriceP() {
		return currentpriceP;
	}

	public void setCurrentpriceP(double currentpriceP) {
		BSOptionPricing.currentpriceP = currentpriceP;
	}
*/
	public void setRiskFreeRate(double riskFreeRate) {
		BSOptionPricing.riskFreeRate = riskFreeRate;
	}

	public double getMonthsToExpiry() {
		return monthsToExpiry;
	}

	public void setMonthsToExpiry(double monthsToExpiry) {
		BSOptionPricing.monthsToExpiry = monthsToExpiry;
	}

	public double getVolatility() {
		return volatility;
	}

	public void setVolatility(double volatility) {
		BSOptionPricing.volatility = volatility;
	}

	// public boolean isCall() {
	// return isCall;
	// }

	// public void setCall(boolean isCall) {
	// this.isCall = isCall;
	// }

	public boolean calculate() {
		return true;
	}
}
