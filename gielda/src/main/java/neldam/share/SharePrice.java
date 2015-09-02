package neldam.share;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SharePrice {
	// key - date , value - price in that date
	private Map<Date,Double> sharePrices = new HashMap<Date,Double>();
	
	public void put(Date data, Double price){
		this.sharePrices.put(data, price);		
	}
	
	public Double get(Date date){
		return this.sharePrices.get(date);
	}
	
}
