package com.flippedshield.monopoly;

public abstract class Space {
	protected String name;
	
	public Space(String name){
		setName(name); 
	}
	
	public abstract boolean onLanding(Player player);
	public abstract void onLeaving(Player player);
	
	public void setName(String name) { this.name = name; } 
	public String getName() { return name; }

}
