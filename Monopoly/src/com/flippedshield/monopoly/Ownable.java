package com.flippedshield.monopoly;

public interface Ownable {
	
	public boolean isPurchased();
	public void isPurchased(boolean isPurchased);
	public void changeOwner(Player owner);
	public int calculateRentCharge();
	
}
