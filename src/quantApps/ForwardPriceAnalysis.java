package quantApps;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import ir.InterestRate;
import futures.Forwards;

public class ForwardPriceAnalysis {
	
	ForwardPriceAnalysis(){
	}
	
	public static void main(String[] args) {
		NumberFormat formatter = NumberFormat.getNumberInstance();
		formatter.setMaximumFractionDigits(4);
		formatter.setMinimumFractionDigits(3);
		double forprice;
		double monthvalue = 0.08333;
		double currenttime = 0.0;
		double delprice = delpriceNoinc(900.80, 0.41665, 0.05);
		double delpricenew = delpriceNoinc(910.8, 0.41665, 0.05);
		forprice = fpriceNoinc(900.8, 0.41665, 919.7628, 0.05);
		try{
			PrintWriter pw = new PrintWriter(new FileWriter("c:\\Joakim\\Java\\data_for_ForwardPriceAnalysis-a.txt"));
			PrintWriter w = new PrintWriter(new FileWriter("c:\\Joakim\\Java\\data_for_ForwardPriceAnalysis-b.txt"));
			System.out.println("Delivery Price == " + formatter.format(delprice));
			System.out.println("Delivery Price New == " + formatter.format(delprice));
			for(int i=0; i<6; i++){
				forprice = fpriceNoinc(900.80,0.41665, currentime, delprice, 0.05);
				System.out.println("Forward Value == " + formatter.format(forprice));
				pw.println(formatter.format(forprice) + "," + formatter.format(currenttime));
				currentime += monthvalue;
			}
			System.out.println("Delivery Price == " + formatter.format(delprice));
			for(int i=0; i<6; i++) {
				forprice = fpriceNoinc(910.80,0.41665,currentime,delprice,0.05);
				System.out.println("Forward Value == " + formatter.format(forprice));
				w.println(formatter.format(forprice) + "," + formatter.format(currentime));
				currentime += monthvalue;
			}
			w.println(" ");
			// pw.close();
			w.close();
		} catch(IOException foe) {
			System.out.println(foe);
		}
		
	}

}
