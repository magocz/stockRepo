package neldam.strategy.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import neldam.broker.Broker;
import neldam.share.Share;
import neldam.stock.Stock;
import neldam.strategy.Strategy;

public class MarketTiming implements Strategy {
	
	private List<String> intrestetShares = new ArrayList<String>();

	public List<String> think2buy() {
		List<String> share2buy = new ArrayList<String>();
		for(String shareName : intrestetShares){
			if(Stock.isGrowing(shareName)){
				share2buy.add(shareName);
			}
		}
		return share2buy;
	}
	
	public List<String> think2sale(Map<String, Share> shareMap) {
		List<String> share2sale = new ArrayList<String>();
		for (Entry<String, Share> entry : shareMap.entrySet()) {
			if (Broker.isProfit(entry.getKey(), entry.getValue().getPrice())) {
				share2sale.add(entry.getKey());
			}
		}		
		return share2sale;		
	}

	public List<String> think2buy(Double money) {
		// TODO Auto-generated method stub
		return null;
	}

}
