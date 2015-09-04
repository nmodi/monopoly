package com.flippedshield.monopoly;

public class FeeSpace extends Space implements Ownable {
	
	public FeeSpace(String name)
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

	@Override
	public int calculateRentCharge() {
		// TODO Auto-generated method stub
		return 0;
	}

}
