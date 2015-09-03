package com.flippedshield.monopoly;

public class Game {
	
	private Board board;
	private Bank bank;
	
	{

		bank = new Bank();
		board = new Board();
	}
	
	public static void main(String[] args) {

	}
	
	public Board getBoard() { return board; }
	public Bank getBank() { return bank; }
}
