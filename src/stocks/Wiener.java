package stocks;

/**
Copyright (C) 2013 QuantFish.com
This source code is released under the Artistic License 2.0.
Code license: http://www.opensource.org/licenses/artistic-license-2.0.php
*/
import java.util.Random;

public class Wiener {
	
	public Wiener() {
	}
	
	public double wienerProc( double t)
	{
		Random r= new Random();
		double epsilon=r.nextGaussian();
		return Math.sqrt(t)*epsilon;
	}
}


