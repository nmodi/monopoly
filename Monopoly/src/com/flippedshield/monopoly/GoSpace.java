package com.flippedshield.monopoly;

public class GoSpace extends Space {

	public GoSpace(String name) {
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
