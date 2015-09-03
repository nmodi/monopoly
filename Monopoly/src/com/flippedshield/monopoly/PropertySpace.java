package com.flippedshield.monopoly;

import java.util.ArrayList;

public class PropertySpace extends Space implements Improvable, Ownable {

	private ArrayList<BuildingToken> buildingTokenList;
	private Deed deed;
	private Player owner;
	private boolean isPurchased;
	
	public PropertySpace(Deed deed){
		super(deed.getName());
		setDeed(deed);
		
		buildingTokenList = new ArrayList<BuildingToken>();
	}
	
	public ArrayList<BuildingToken> getBuildingTokenList() {
		return buildingTokenList;
	}
	
	public void setDeed(Deed deed)
	{
		this.deed = deed;
	}

	@Override
	public void onLanding() {
		
	}

	@Override
	public void onLeaving() {
		
	}

	@Override
	public boolean isPurchased() {
		return false;
	}

	@Override
	public void setOwner(Player owner) {
		this.owner = owner;
	}

	@Override
	public void isPurchased(boolean isPurchased) {
		this.isPurchased = isPurchased;
	}
}
