package com.flippedshield.monopoly;

public class BankerPlayer extends Player implements Banker {

	public BankerPlayer(String name, int lastTwoRolls) {
		super(name, lastTwoRolls);
	}

	public BankerPlayer(String name) {
		super(name);
	}

}
