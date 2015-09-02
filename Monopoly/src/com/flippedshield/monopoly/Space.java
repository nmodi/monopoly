package com.flippedshield.monopoly;

public class Space {
	protected String name;
	
	Space(){
		new Space("Default cell"); 
	}
	
	Space(String name){
		this.name = name; 
	}
	
}
