package quantApps;

import ir.Volatility;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;

public class bondVolatility {

	/** Creates a new instance of Exercise 3.5 */
	public bondVolatility() {
	}

	/**
	 * 
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		NumberFormat formatter = NumberFormat.getNumberInstance();
		formatter.setMaximumFractionDigits(4);
		formatter.setMinimumFractionDigits(4);
		double currentprice;
		double par;

		try {
			PrintWriter w = new PrintWriter(new FileWriter(
					"c:\\Joakim\\Java\\Ex2_8data.txt"), true);
			double[] coups = { 2.0, 5.0, 8.0, 9.0, 10.0 };
			double[] maturity = { 3.0, 5.0, 8.0, 10.0, 30.0 };
			par = 100.0;
			double yield = 5.0;
			Volatility v = new Volatility(100.0, 2.0);

			System.out
					.println("Coupon Initial   Price   PlussPVBP  LessPVBP  Maturity");

			while (yield < 11.0) {
				for (double d : coups) {
					for (double f : maturity) {
						v.pVbPoints(yield, f, d, 1.0);
						currentprice = v.getRelativeValue();
						double up = v.getRelativeValue();
						double down = v.getRelativeValuelow();
						w.println(f + "," + formatter.format(currentprice));
						System.out.println(" " + d + "   $"
								+ formatter.format(currentprice) + "   $"
								+ formatter.format(v.getRelativeValue()) + "  "
								+ f + formatter.format(v.getUpPp()) + "    "
								+ formatter.format(v.getValuePUp()));
					}
				}
				yield += yield;
			}
			w.println(" ");
			w.close();

		} catch (IOException foe) {
			System.out.println(foe);
		}
	}
}
