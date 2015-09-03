package com.flippedshield.monopoly;

import java.util.ArrayList;

public class PropertySpace extends Space implements AbstractPropertySpace, Ownable {

	private int cost;
	private ArrayList<BuildingToken> buildingTokenList;
	
	PropertySpace(String name, int cost){
		this.name = name; 
		this.cost = cost; 
	}
	
	public ArrayList<BuildingToken> getBuildingTokenList() {
		return buildingTokenList;
	}
}
