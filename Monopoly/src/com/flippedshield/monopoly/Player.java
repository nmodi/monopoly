package com.flippedshield.monopoly;

import java.util.ArrayList;

public class Player {
	
	private static final int STARTING_ROLL_HISTORY = 00;
	private static final int STARTING_JAIL_CARDS = 0;

	private String name;
	private int lastTwoRolls;
	private int wealth;
	private int jailCards;
	private ArrayList<Deed> ownedDeeds;
	
	/**
	 * Creates player with name and wealth
	 * @param name
	 */
	public Player(String name, int wealth)
	{
		setName(name);
		initLastTwoRolls();
		initOwnedDeedsList();
		setWealth(wealth);
		setJailCards(STARTING_JAIL_CARDS);
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
	
	public void initOwnedDeedsList()
	{
		ownedDeeds = new ArrayList<Deed>();
	}
	
	private void initLastTwoRolls()
	{
		setLastTwoRolls(STARTING_ROLL_HISTORY);
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

	public int getJailCards() {
		return jailCards;
	}
	
	public void setJailCards(int jailCards)
	{
		this.jailCards = jailCards;
	}
	
	public ArrayList<Deed> getOwnedDeeds()
	{
		return ownedDeeds;
	}
	
	public void setOwnedDeeds(ArrayList<Deed> ownedDeeds)
	{
		this.ownedDeeds = ownedDeeds;
	}
}
