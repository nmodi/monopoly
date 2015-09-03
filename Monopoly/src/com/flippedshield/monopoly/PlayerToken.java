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
		setSymbol(next.get("symbol").toString().charAt(0));
	}

	/*
	 * === GETTERS AND SETTERS ======================================
	 */
	public boolean getImprisonmentStatus() { return this.isImprisoned; }
	
	public void setImprisonment(boolean isImprisoned)
	{
		this.isImprisoned = isImprisoned;
	}
}
