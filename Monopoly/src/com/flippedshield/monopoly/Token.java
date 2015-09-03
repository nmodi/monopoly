package com.flippedshield.monopoly;

/**
 * Defines the basic token attributes and methods
 * @author plk4578
 *
 */
public abstract class Token {
	
	private int position;
	private String name; 
	private String symbol;
	

	/*
	 * === GETTERS AND SETTERS ======================================
	 */
	public void setName(String name) { this.name = name; } 
	public String getName() { return name; } 
	public int getPosition() { return this.position; }
	public void setPosition(int position) { this.position = position; }
	public String getSymbol() { return this.symbol; }
	public void setSymbol(String symbol) { this.symbol = symbol; }
	
}
//
///**
// * Defines the token types and their ASCII art.
// * Later the ASCII art string can be changed to an image/img src or something.
// * @author plk4578
// *
// */
//enum TokenSymbol
//{
//	CITY_BLOCK("X"),
//	KEY_TO_THE_CITY("p---k"),
//	DOG("BARK"),
//	HAND("HAND"),
//	STAR("STAR"),
//	HAT("HAT");
//	
//	String symbol;
//	
//	private TokenSymbol(String symbol)
//	{
//		this.symbol = symbol;
//	}
//}
