package com.flippedshield.monopoly;

public class PropertySpace extends Space implements AbstractPropertySpace, Ownable {

	private int cost; 
	
	PropertySpace(String name, int cost){
		this.name = name; 
		this.cost = cost; 
	}
}
