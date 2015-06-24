package quantApps;

import java.text.NumberFormat;

import options.OptionLimits;
import static java.lang.Math.max;

public class OptionLowerLimitsPut {

	public OptionLowerLimitsPut() {
	}

	public static void main(String[] args) {
		NumberFormat formatter = NumberFormat.getNumberInstance();
		formatter.setMaximumFractionDigits(2);
		formatter.setMinimumFractionDigits(2);
		OptionLimits ops = new OptionLimits();
		double[] stockprice = { 38.0, 39.0, 40.0, 45.0, 38.0 };
		double[] strikeprice = { 40.5, 41.5, 42.5, 47.5, 41.0 };
		double time = 0.5;
		double interest = 0.11;
		double[] premiums = ops.lowerlimitPut(stockprice, interest, time,
				strikeprice);
		for (double pr : premiums) {
			System.out.println("Put option premium per share == "
					+ formatter.format(pr));
		}
	}

}
