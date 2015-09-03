package com.flippedshield.monopoly;

public class Game {
	
	private static Board board;
	private static Bank bank;
	private static boolean gameWon = false; 
//	private static boolean DEBUG_MODE = true; 
	
	private static int playerCount; 
	
	static Game game; 
	
	public Game(){ 
		initGame(); 
	}
	
	public static void initGame() 
	{
		bank = new Bank();
		board = new Board();
	}
	
	public static void main(String[] args) {
		mainGameLoop(); 
	}
	
	private static void mainGameLoop() {
		System.out.println("Welcome to The Money Game!");	
		game = new Game(); 
		while(!gameWon){
			gameWon = nextRound(); 		
//			endGame(); 
		}
	}
	
	
	private static boolean nextRound() {
		playerCount = board.getPlayers().size(); 
		
		setTurnOrder(); 
		
		for (int i = 0; i < playerCount; i++){
			nextTurn(i); 
		}	
		return false; 
	}
	
	private static boolean nextTurn(int playerIndex) {
		
		return false; 
	}
	
	private static void setTurnOrder(){
		Die die = board.getDie(); 
		
		int[] firstTurnRollCounts; 
		for (int i = 0; i < playerCount; i++){
			
		}
		
	}

	public static void endGame() { gameWon = true; }
	public Board getBoard() { return board; }
	public static Bank getBank() { return bank; }
}
