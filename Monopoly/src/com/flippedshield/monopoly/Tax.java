package com.flippedshield.monopoly;

public class Tax extends Space {

	public Tax(String name) {
		super(name);
	}

	@Override
	public boolean onLanding(Player player) {
		return false; 
	}

	@Override
	public void onLeaving(Player player) {
		
	}

}
