package neldam.strategy.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import neldam.stock.Stock;
import neldam.strategy.Strategy;
import neldam.time.Time;

public class BuyAndHold implements Strategy {

	private Map<Date, String> shareMap = new HashMap<Date, String>();
	private List<String> intrestetShares = new ArrayList<String>();

	public List<String> think2sale() {
		List<String> share2sell = new ArrayList<String>();
		for (Entry<Date, String> entry : this.shareMap.entrySet()) {
			if (entry.getKey().equals(Time.getCurrentDay())) {
				share2sell.add(entry.getValue());
			}
		}		
		return share2sell;
	}
	
	public List<String> think2buy() {
		List<String> share2buy = new ArrayList<String>();
		for(String shareName : intrestetShares){
			if(Stock.isGrowing(shareName)){
				share2buy.add(shareName);
			}
		}
		return share2buy;
	}
	
	public void put(Date date, String shareName){
		shareMap.put(date, shareName);
	}

	public List<String> getIntrestetShares() {
		return intrestetShares;
	}

	public void setIntrestetShares(List<String> intrestetShares) {
		this.intrestetShares = intrestetShares;
	}

	public List<String> think2buy(Double money) {
		// TODO Auto-generated method stub
		return null;
	}
}
