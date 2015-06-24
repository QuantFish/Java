package quantApps;

import static ir.InterestRate.pvancert;
import static java.lang.Math.pow;
import ir.Volatility;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;

public class BondYieldAnalysis {
	/** Creates a new instance of BondYieldAnalysis */
	public BondYieldAnalysis() {
	}

	public static void main(String[] args) {
		NumberFormat formatter = NumberFormat.getNumberInstance();
		formatter.setMaximumFractionDigits(7);
		formatter.setMinimumFractionDigits(7);
		Volatility vol = new Volatility();
		double par;
		double currentprice;
		double newprice;

		try {
			PrintWriter w = new PrintWriter(new FileWriter(
					"C:\\Joakim\\Java\\data_for_bondYieldAnalysis.txt"), true);
			double[] coups = { 5.0, 10.0, 15.0 };
			double[] maturity = { 1.0, 2.0, 3.0, 4.0, 5.0, 10.0, 15.0, 30.0 };
			par = 100;
			double yield = 0.1;
			Volatility v = new Volatility(par, 2.0);
			System.out
					.println("Maturity InitialPrice  Yield%   Newprice    NewYield%  Value of 1/32 ");
			for (double d : coups) {
				w.println(d + ",");

				for (double f : maturity) {
					currentprice = (((pvancert(yield / 2.0, f * 2))
							* (d / 100.0 * par) / 2.0) + (par / pow(
							(1 + yield / 2.0), f * 2)));
					v.yieldForPpoint(d, currentprice, f, 0.0950, 1.0 / 32.0);
					double up = v.getValuePUp();
					double down = v.getValuePDown();
					System.out.println("  " + f + "    "
							+ formatter.format(currentprice) + "  "
							+ formatter.format(v.getInitialPpYld()) + "  "
							+ formatter.format(v.getPriceupPp()) + "  "
							+ formatter.format(v.getUpPp()) + "  "
							+ formatter.format(v.getValuePUp()));
					w.println(formatter.format(v.getValuePUp()));
				}
			}
			w.println(" ");
			w.close();
		} catch (IOException foe) {
			System.out.println(foe);
		}
	}
}
