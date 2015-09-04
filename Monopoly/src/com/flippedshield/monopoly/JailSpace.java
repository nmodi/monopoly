package com.flippedshield.monopoly;

public class JailSpace extends Space {

	public JailSpace(String name)
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
