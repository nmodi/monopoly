package com.flippedshield.monopoly;

public class Game {
	
	private static Board board;
	private static Bank bank;
	private static boolean gameStarted = true; 
	
	private static boolean DEBUG__MODE = true; 
	
	public Game(){ 
		initGame(); 
	}
	
	public static void initGame() {
		board = new Board(); 
		bank = new Bank();
	}
	
	public static void main(String[] args) {
		mainGameLoop(); 
	}
	
	private static void mainGameLoop() {
		System.out.println("Welcome to The Money Game!");	
		Game game = new Game(); 
		while(gameStarted){
			endGame(); 
		}
		
	}

	public static void endGame() { gameStarted = false; }
	public Board getBoard() { return board; }
	public Bank getBank() { return bank; }
}
