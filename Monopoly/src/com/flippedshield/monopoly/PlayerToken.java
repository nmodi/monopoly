package com.flippedshield.monopoly;

import org.json.simple.JSONObject;

/**
 * Extends Token class and defines a Player token
 * @author plk4578
 *
 */
public class PlayerToken extends Token {
	
	private boolean isImprisoned;
	private int turnsImprisoned; 
	
	
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
	
	public int getTurnsImprisoned(){
		return turnsImprisoned; 
	}
	
	public void incrementTurnsImprisoned(){
		turnsImprisoned++; 
	}

	public void resetTurnsImprisoned() {
		turnsImprisoned = 0; 
		
	}


}
