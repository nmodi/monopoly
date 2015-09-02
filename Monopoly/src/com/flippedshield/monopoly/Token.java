package com.flippedshield.monopoly;

/**
 * Defines the basic token attributes and methods
 * @author plk4578
 *
 */
public abstract class Token {
	
	private int position;
	private TokenSymbol symbol;
	
	/*
	 * === GETTERS AND SETTERS ======================================
	 */
	public int getPosition() { return this.position; }
	
	public void setPosition(int position)
	{
		this.position = position;
	}
	
	public TokenSymbol getSymbol() { return this.symbol; }
	
	public void setSymbol(TokenSymbol symbol)
	{
		this.symbol = symbol;
	}
	
}

/**
 * Defines the token types and their ASCII art.
 * Later the ASCII art string can be changed to an image/img src or something.
 * @author plk4578
 *
 */
enum TokenSymbol
{
	CITY_BLOCK("X"),
	KEY_TO_THE_CITY("p---k"),
	DOG("BARK"),
	HAND("HAND"),
	STAR("STAR"),
	HAT("HAT");
	
	String symbol;
	
	private TokenSymbol(String symbol)
	{
		this.symbol = symbol;
	}
}
