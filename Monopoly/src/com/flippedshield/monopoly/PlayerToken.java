package com.flippedshield.monopoly;

/**
 * Extends Token class and defines a Player token
 * @author plk4578
 *
 */
public class PlayerToken {
	
	private boolean isImprisoned;
	
	
	/*
	 * === GETTERS AND SETTERS ======================================
	 */
	public boolean isImprisoned() { return this.isImprisoned; }
	
	public void imprisoned(boolean isImprisoned)
	{
		this.isImprisoned = isImprisoned;
	}
}
