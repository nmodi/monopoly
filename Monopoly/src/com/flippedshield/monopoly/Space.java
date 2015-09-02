package com.flippedshield.monopoly;

public class Space {
	protected String name;
	
	Space(){
		new Space("Default cell"); 
	}
	
	Space(String name){
		setName(name); 
	}

	
	public void setName(String name) { this.name = name; } 
	public String getName() { return name; }
	
}
