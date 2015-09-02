package neldam.clent;

import java.util.Date;

import neldam.strategy.Strategy;

public class Client {
	private Integer id;
	private UserData userData;
	private Strategy strategy;

	public Client(Integer id, UserData userData, Strategy strategy) {
		this.id = id;
		this.userData = userData;
		this.strategy = strategy;
	}
	
	public void doSomething(Date data){
	}
}
