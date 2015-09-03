package com.flippedshield.monopoly;

import java.util.ArrayList;

public class PropertySpace extends Space implements Improvable, Ownable {

	private ArrayList<BuildingToken> buildingTokenList;
	private Deed deed;
	
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
}
