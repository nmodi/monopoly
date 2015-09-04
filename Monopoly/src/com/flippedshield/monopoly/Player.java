package com.flippedshield.monopoly;


import java.util.ArrayList;

import org.json.simple.JSONObject;

public class Player {
	
	private static final int STARTING_ROLL_HISTORY = 0;
	private static final int STARTING_JAIL_HISTORY = 0;
	private static final int STARTING_JAIL_CARDS = 0;
	private static final int DEFAULT_STARTING_WEALTH = 1000;
	
	private String name;
	private int consecutiveDoubles;
	private long wealth;
	private int jailCards;
	private int turnsInJail; 
	private ArrayList<Deed> ownedDeeds;
	private PlayerToken token; 
	private boolean lostGame; 
	 
	
	public Player(){}
	
	/**
	 * Creates player using JSON player object
	 * @param name
	 */
	public Player(JSONObject playerObj)
	{
		String name = playerObj.get("name").toString();
		setName(name);
		initDoubleCount();
		setWealth(DEFAULT_STARTING_WEALTH);
		initOwnedDeedsList(); 
		System.out.println(name + " has joined the game with $" + wealth);
		lostGame = false; 
	}
	
	/**
	 * Creates player with name and wealth
	 * @param name
	 */
	public Player(String name, int wealth)
	{
		setName(name);
		initDoubleCount();
		initOwnedDeedsList();
		setWealth(DEFAULT_STARTING_WEALTH);
		setJailCards(STARTING_JAIL_CARDS);
	}
	
	/**
	 * Creates player with name
	 * @param name
	 */
	public Player(String name)
	{
		setName(name);
		initDoubleCount();
		setWealth(DEFAULT_STARTING_WEALTH);
	}
	
	public void initOwnedDeedsList()
	{
		ownedDeeds = new ArrayList<Deed>();
	}
	
	private void initDoubleCount()
	{
		resetDoubleCount(); 
	}
	
	public String getName() { return name; }
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getconsecutiveDoubleCount() { return consecutiveDoubles; }
	
	public void incrementDoubleCount() 
	{
		consecutiveDoubles++; 
	}

	public long getWealth() { return wealth; }
	
	public void setWealth(long wealth) {
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
	
	public PlayerToken getPlayerToken(){
		return token; 
	}

	public void setPlayerToken(PlayerToken newToken) {
		this.token = newToken; 
		System.out.println(name + " has the " + token.getName() + " token! " + token.getSymbol());
	}

	public boolean rolledDoubles() {
		switch (getconsecutiveDoubleCount()){
		case 0: 
		case 1:	incrementDoubleCount();
				break; 
		case 2: resetDoubleCount(); 
				return true; 
		default: System.out.println("this should never happen");
		}
		
		return false; 		
	}

	public void resetDoubleCount() {
		consecutiveDoubles = STARTING_ROLL_HISTORY; 
	}
	
	public int getTurnsInJail() {
		return turnsInJail; 
	}
	
	public void incrementTurnsInJail() {
		turnsInJail++; 
	}
	
	public void resetTurnsInJail() {
		setTurnsInJail(STARTING_JAIL_HISTORY); 
	}
	
	private void setTurnsInJail(int turns) {
		turnsInJail = turns; 
	}
	
	public void adjustWealth(long amount){
		setWealth(getWealth() + amount);
	}

	public void addOwnedDeeds(Deed deed) {
		getOwnedDeeds().add(deed); 
	}

	public void removeDeed(Deed deed) {
		getOwnedDeeds().remove(deed); 	
	}
	
	public void playerLostGame(){
		lostGame = true; 
	}
}
