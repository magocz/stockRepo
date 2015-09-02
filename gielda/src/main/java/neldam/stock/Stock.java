package neldam.stock;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import neldam.share.SharePrice;
import neldam.time.Time;

public class Stock {
	// key - name of share
	private static Map<String, SharePrice> shareMap = new HashMap<String, SharePrice>();

	public void put(String shareName, SharePrice sharePrice) {
		this.shareMap.put(shareName, sharePrice);
	}

	public Double getSharePrice(String shareName, Date date) {
		return shareMap.get(shareName).get(date);
	}
	
	public Double getSharePrice(String shareName){
		return shareMap.get(shareName).get(Time.getCurrentDay());
	}

	public SharePrice getSharePriceFromTo(String shareName, Integer number) {
		SharePrice sharePrice = new SharePrice();
		Date date = Time.getCurrentDay();
		for (int i = 0; i < number; i++) {
			sharePrice.put(date, shareMap.get(shareName).get(date));
			date = decrementDate(date);
		}
		return sharePrice;
	}

	private static Date decrementDate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, 1);
		return c.getTime();
	}

	public static boolean isGrowing(String shareName) {
		if (shareMap.get(shareName).get(decrementDate(Time.getCurrentDay())) != null) {
			if (shareMap.get(shareName).get(Time.getCurrentDay()) < shareMap.get(shareName)
					.get(decrementDate(Time.getCurrentDay()))) {
				return true;
			}
		}
		return false;
	}
}
