package com.flippedshield.monopoly;

import java.util.ArrayList;

public class PropertySpace extends Space implements AbstractPropertySpace, Ownable {

	private int cost;
	private ArrayList<BuildingToken> buildingTokenList;
	private Deed deed;
	
	public PropertySpace(Deed deed){
//		this.name = name; 
//		this.cost = cost; 
		this.deed = deed;
		super.setName(deed.getName());
	}
	
	public ArrayList<BuildingToken> getBuildingTokenList() {
		return buildingTokenList;
	}
}
