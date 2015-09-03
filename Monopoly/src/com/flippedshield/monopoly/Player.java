package com.flippedshield.monopoly;

import org.json.simple.JSONObject;

public class Player {

	private String name;
	private int lastTwoRolls;
	private int wealth;
	
	private static final int DEFAULT_STARTING_WEALTH = 500; 
	
	/**
	 * Creates player using JSON player object
	 * @param name
	 */
	public Player(JSONObject playerObj)
	{
		String name = playerObj.get("name").toString();
		setName(name);
		initLastTwoRolls();
		setWealth(DEFAULT_STARTING_WEALTH);
	}
	
	/**
	 * Creates player with name and wealth
	 * @param name
	 */
	public Player(String name, int wealth)
	{
		setName(name);
		initLastTwoRolls();
		setWealth(DEFAULT_STARTING_WEALTH);
	}
	
	/**
	 * Creates player with name
	 * @param name
	 */
	public Player(String name)
	{
		setName(name);
		initLastTwoRolls();
		setWealth(DEFAULT_STARTING_WEALTH);
	}
	
	private void initLastTwoRolls()
	{
		setLastTwoRolls(00);
		System.out.println(lastTwoRolls);
	}
	
	public String getName() { return name; }
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getLastTwoRolls() { return lastTwoRolls; }
	
	public void setLastTwoRolls(int lastTwoRolls) 
	{
		this.lastTwoRolls = lastTwoRolls;
	}

	public int getWealth() { return wealth; }
	
	public void setWealth(int wealth) {
		this.wealth = wealth;
	}
}
