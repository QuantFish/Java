package quantApps;

import static java.lang.Math.exp;
import static java.lang.Math.log;
import static java.lang.Math.sqrt;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;

import stocks.MonteCarloPrices;
import core.DataDispersion;
import quantApps.Fileinput;

public class DemoModel {
	
	public DemoModel() {
	}
	
	public static void main(String[] args) {
		NumberFormat formatter = NumberFormat.getNumberInstance();
		formatter.setMaximumFractionDigits(4);
		formatter.setMinimumFractionDigits(3);
		
		double[] data = new double[223];
		double[] expon = new double[223];
		double[] monte = new double[223];
		double[] drift = new double[224];
		MonteCarloPrices m = new MonteCarloPrices(223);
		
		fileinput("c:\\Joakim\\Java\\IBM.txt",223);
		data = getFileData(); // get raw data
		for(int i=1; i<data.length; i++) {
			System.out.println("DATA == " + data[i-1]);
			expon[i-1] = log((data[i] / data[i-1]));
			System.out.println("EXPON data == " + expon[i-1]);
		}
		double s = variance(expon); // variance and mean of the log ratios
		double gsd = sqrt(DgetVariance());
		double gmean = DgetMean();
		double time = 1.0;
		double t =(1.0 / data.length);
		double so = data[0];
		drift[0] = so;
		int k = 1;
		
		monte = m.simValueP(gmean, gsd, so, time); // Each trading day is 1/223 which is 0.00448
		
		try{
			PrintWriter pw = new PrintWriter(new FileWriter("c:\\Joakim\\Java\\exampleIBMExSim3.txt"), true);
			PrintWriter w = new PrintWriter(new FileWriter("c:\\Joakim\\Java\\exampleIBMExModellRawA.txt"), true);
			PrintWriter dw = new PrintWriter(new FileWriter("c:\\Joakim\\Java\\exampleIBMExModeldriftA.txt"), true);
			for(double d2:monte) {
				drift[k] = (so * (exp(k * t * gmean)));
				System.out.println("Simulated data " + formatter.format(exp(d2)) + "DRIFT POINT MOVEMENT = " + formatter.format(drift[k-1]) + "RAW DATA FROM SOURCE = " + data[k-1]);
				pw.println((exp(d2)) + ",");
				w.println(data[k-1] + ",");
				dw.println(drift[k-1] + ",");
				k++;
			}
			pw.println("");
			w.println("");
			dw.println("");
			w.close();
			pw.close();
			dw.close();
		} catch(IOException foe) {
			System.out.println(foe);
		}
		
	}

}
