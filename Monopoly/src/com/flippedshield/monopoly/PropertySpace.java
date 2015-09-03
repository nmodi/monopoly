package com.flippedshield.monopoly;

import java.util.ArrayList;

public class PropertySpace extends Space implements AbstractPropertySpace, Ownable {

	private int cost;
	private ArrayList<BuildingToken> buildingTokenList;
	private Deed deed;
	
	public PropertySpace(Deed deed){
//		this.name = name; 
//		this.cost = cost; 
		setDeed(deed);
		super.setName(deed.getName());
		
		buildingTokenList = new ArrayList<BuildingToken>();
	}
	
	public ArrayList<BuildingToken> getBuildingTokenList() {
		return buildingTokenList;
	}
	
	public void setDeed(Deed deed)
	{
		this.deed = deed;
	}
}
