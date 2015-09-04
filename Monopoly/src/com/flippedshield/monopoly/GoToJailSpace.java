package com.flippedshield.monopoly;

public class GoToJailSpace extends Space {

	public GoToJailSpace(String name)
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
