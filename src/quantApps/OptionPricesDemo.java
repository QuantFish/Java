package quantApps;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;

import options.BlackScholes;

public class OptionPricesDemo {

	public static void main(String[] args) {
		NumberFormat formatter = NumberFormat.getNumberInstance();
		formatter.setMaximumFractionDigits(4);
		formatter.setMinimumFractionDigits(3);
		double currentpriceC;
		double currentpriceP;
		double gamma;
		double deltaCall;
		double thetaCall;
		double rhoCall;
		double deltaPut;
		double thetaPut;
		double rhoPut;
	
		int i;

		try {
			PrintWriter w = new PrintWriter(new FileWriter(
					"c:\\Joakim\\Java\\OptionPricesDemo.txt"), true);
			double sprice = 45;
			double strike = 46;
			double volatility = 0.2;
			double time = 0.5;
			double rate = 0.4;
			double carryrate = rate;
			BlackScholes BS = new BlackScholes(carryrate);
			for (i = 1; i < 10; i++) {
				BS.bscholEprice(sprice, strike, volatility, time, rate);
				currentpriceC = BS.getCalle();
				currentpriceP = BS.getPute();
				gamma = BS.getGamma();
				deltaCall = BS.getDeltac();
				thetaCall = BS.getThetac();
				rhoCall = BS.getRhoc();
				deltaPut = BS.getDeltap();
				thetaPut = BS.getThetap();
				rhoPut = BS.getRhop();
				
				System.out.println("The spot price is: £"
						+ formatter.format(sprice)
						+ ". So one call option will cost: £"
						+ formatter.format(currentpriceC) + "\n");
				System.out.println("The gamma value is: "
						+ formatter.format(gamma) + "\n");
				System.out.println("The delta value is: "
						+ formatter.format(deltaCall) + "\n");
				System.out.println("The theta value is: "
						+ formatter.format(thetaCall) + "\n");
				System.out.println("The rho value is: "
						+ rhoCall + "\n");
				System.out.println("____________________________________________________________ \n");
				
				System.out.println("The spot price is: £"
						+ formatter.format(sprice)
						+ ". So one put option will cost: £"
						+ formatter.format(currentpriceP) + "\n");
				System.out.println("The gamma value is: "
						+ formatter.format(gamma) + "\n");
				System.out.println("The delta value is: "
						+ formatter.format(deltaPut) + "\n");
				System.out.println("The theta value is: "
						+ formatter.format(thetaPut) + "\n");
				System.out.println("The rho value is: "
						+ rhoPut + "\n");
				System.out.println("____________________________________________________________ \n");
				sprice++;
			}
			sprice += sprice;
			w.println(" ");
			w.close();

		} catch (IOException foe) {
			System.out.println(foe);
		}

	}

}
