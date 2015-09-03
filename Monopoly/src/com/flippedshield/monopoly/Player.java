package com.flippedshield.monopoly;

public class Player {

	private String name;
	
	/**
	 * Creates player with name
	 * @param name
	 */
	public Player(String name)
	{
		setName(name);
	}
	
	public String getName() { return name; }
	
	public void setName(String name) {
		this.name = name;
	}
}
