package com.flippedshield.monopoly;

public class BankerPlayer extends Player implements Banker {
	private static BankerPlayer banker = null; 
	
	public static BankerPlayer getBanker() {
		if (banker == null){
			banker = new BankerPlayer("Banker"); 
		}
		
		return banker; 
	}
	
	protected BankerPlayer(){}

	private BankerPlayer(String name, int lastTwoRolls) {
		super(name, lastTwoRolls);
	}

	private BankerPlayer(String name) {
		super(name);
	}

}
