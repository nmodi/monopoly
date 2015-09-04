package com.flippedshield.monopoly;

public class FreeParkingSpace extends Space {

	public FreeParkingSpace(String name)
	{
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
