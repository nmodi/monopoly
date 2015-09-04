package com.flippedshield.monopoly;

import org.json.simple.JSONObject;

/**
 * Extends Token class and defines a Player token
 * @author plk4578
 *
 */
public class PlayerToken extends Token {
	
	private boolean isImprisoned;
	
	
	public PlayerToken(JSONObject next) {
		setImprisonment(false); 
		setName(next.get("name").toString());
		setSymbol(next.get("symbol").toString());
	}

	/*
	 * === GETTERS AND SETTERS ======================================
	 */
	public boolean checkIfJailed() { return this.isImprisoned; }
	
	public void setImprisonment(boolean isImprisoned)
	{
		this.isImprisoned = isImprisoned;
	}

	/**
	 * Moves the player by a given number of spaces
	 * @param magnitude 
	 * @return Returns true if the player passes go, returns false otherwise. 
	 */
	public boolean incrementPosition(int magnitude) {
		int newPosition = getPosition() + magnitude; 
		if (Game.getDebugMode()){			
			System.out.println("magnitude " + magnitude);
			System.out.println("new position (nonmod)" + newPosition);
			
			if (newPosition > Board.TOTAL_NUMBER_OF_SPACES) {
				System.out.println("new position (mod)" + newPosition);
			}
		}
		setPosition(newPosition % Board.TOTAL_NUMBER_OF_SPACES); 
		return false; 
	}
}
