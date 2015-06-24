package quantApps;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Formatter;

import bonds.AccruedConvention;

public class bondPrices {

	public bondPrices() {
	}
	
	enum Markets {
		UStreasure(1), Irishsemi(2), UScorporate(5);
		private final int value;
		Markets(int value) {
			this.value = value;
		}
		public int mkt() {
			return value;
		}
	}
		
	public static void main(String[] args) {
		NumberFormat formatter = NumberFormat.getNumberInstance();
		formatter.setMaximumFractionDigits(6);
		formatter.setMinimumFractionDigits(3);
		Calendar settlement = Calendar.getInstance();
		Calendar nextcoupon = Calendar.getInstance();
		settlement.set(2004, 5, 3); //
		nextcoupon.set(2004, 10, 17); // next coupon
		double coupon = 0.12;
		double couponfrequency = 2.0;
		AccruedConvention days = new AccruedConvention();
	}
		
		
}
	
		
		
		for(Markets m: Markets.values()) {
			days.daycounts(m.mkt(), settlement,nextcoupon);
			double daytimes = days.getPreviousCoupondays();
			System.out.println("For The " + m + "The accrued % of the coupon == " + formatter.format((daytimes*100.0)) + "%"+" accrued value per $100 par == $" + Formatter.format((daytimes * (coupon/couponfrequency) * 100.0)));
		}
	}
}
