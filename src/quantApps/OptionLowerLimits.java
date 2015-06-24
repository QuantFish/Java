package quantApps;

import java.text.NumberFormat;

import options.OptionLimits;
import static java.lang.Math.max;

public class OptionLowerLimits {

	public OptionLowerLimits() {
	}

	public static void main(String[] args) {
		NumberFormat formatter = NumberFormat.getNumberInstance();
		formatter.setMaximumFractionDigits(2);
		formatter.setMinimumFractionDigits(2);
		OptionLimits ops = new OptionLimits();
		double[] stockprice = { 51.0, 50.0, 52.3, 53.6, 51.0 };
		double[] strikeprice = { 50.0, 49.5, 51.5, 52.5, 50.5 };
		double time = 0.5;
		double interest = 0.13;
		double[] premiums = ops.lowerlimitCall(stockprice, interest, time,
				strikeprice);
		for (double pr : premiums) {
			System.out.println("Call option premium per share == "
					+ formatter.format(max(pr, 0)));
		}
	}

}
