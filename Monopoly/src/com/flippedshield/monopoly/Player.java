package com.flippedshield.monopoly;

public class Player {

	private String name;
	private int lastTwoRolls;
	private int wealth;
	
	/**
	 * Creates player with name and wealth
	 * @param name
	 */
	public Player(String name, int wealth)
	{
		setName(name);
		initLastTwoRolls();
		setWealth(wealth);
	}
	
	/**
	 * Creates player with name
	 * @param name
	 */
	public Player(String name)
	{
		setName(name);
		initLastTwoRolls();
		setWealth(wealth);
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
