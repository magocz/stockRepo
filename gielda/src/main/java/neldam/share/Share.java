package neldam.share;

public class Share {
	private Double price;
	private Integer number;

	public Share(Double price, Integer number) {
		this.price = price;
		this.number = number;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Share getShare(Integer shareNumber) {
		if(this.number == shareNumber){
			return this;
		}
		if(this.number > shareNumber){
			this.number = this.number - shareNumber;
			return new Share(this.price, shareNumber);
		}
		return null;
	}
	
	public Double getValuation(){
		return this.price * this.number;
	}

}
