package com.flippedshield.monopoly;

public class CardSpace extends Space {

	public CardSpace(String name) {
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
