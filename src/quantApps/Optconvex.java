package quantApps;

public class Optconvex {

	public Optconvex() {
	}

	/**
	 * assumes that the array contains a series of 3 points in the order x1 < x2
	 * < x3 in the series pairs strike price - option price
	 */
	public double convexcheck(double[][] stprseries) {
		double w = ((stprseries[2][0] - stprseries[1][0]) / (stprseries[2][0] - stprseries[0][0]));
		return stprseries[1][1] <= (w * stprseries[0][1] + (stprseries[2][1] - w
				* stprseries[2][1])) ? ((w * stprseries[0][1]) + (stprseries[2][1] - w
				* stprseries[2][1]))
				: 0.0;
	}
}
