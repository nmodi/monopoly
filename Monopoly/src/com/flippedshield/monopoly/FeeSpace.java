package com.flippedshield.monopoly;

public class FeeSpace extends Space implements Ownable {
	
	public FeeSpace(String name)
	{
		super(name);
	}

	@Override
	public void onLanding(Player player) {
		
	}

	@Override
	public void onLeaving(Player player) {
		
	}

	@Override
	public boolean isPurchased() {
		return false;
	}

	@Override
	public void isPurchased(boolean isPurchased) {
		
	}

	@Override
	public void changeOwner(Player owner) {
		
	}

}
