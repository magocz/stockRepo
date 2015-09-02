package neldam.broker;

import neldam.share.Share;
import neldam.share.SharePrice;
import neldam.stock.Stock;
import neldam.time.Time;

public class Broker {
	private final static Double provision = 0.013;
	private static Double provisionValue;
	private static Stock stock = new Stock();

	public static Double sellShare(String shareName, Share share) {
		return countProfit(stock.getSharePrice(shareName, Time.getCurrentDay()), share);
	}

	private static Double countProfit(Double sharePrice, Share share) {
		return ((currentValuation(sharePrice, share.getNumber()) - share.getValuation()) - provisionValue);
	}

	private static Double currentValuation(Double sharePrice, Integer number) {
		Double currentValuation = sharePrice * number;
		provisionValue = currentValuation * provision;
		return currentValuation;
	}

	public static Share buyShare(String shareName, Double money) {
		Double currentSharePrice = stock.getSharePrice(shareName, Time.getCurrentDay());
		return new Share(currentSharePrice, countShareNumber(money, currentSharePrice));
	}

	private static Integer countShareNumber(Double money, Double price) {
		int shareNumber = (int) (money / price);
		money = money - ((shareNumber * price) + ((shareNumber * price)*provision));
		return shareNumber;
	}
	
	public static boolean isProfit(String shareName, Double sharePrice){
		double profit = (sharePrice - stock.getSharePrice(shareName))/stock.getSharePrice(shareName);
		if(profit > provision){
			return true;
		}
		return false;
	}
	
	public static SharePrice getInfoAboutShare(String shareName,Integer number ){
		return stock.getSharePriceFromTo(shareName, number);
	}
	
}
