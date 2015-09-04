package com.flippedshield.monopoly;

import java.util.ArrayList;
import java.util.Collections;

public class Game {
	
	private static Board board;
	private static Bank bank;
	private static boolean gameWon = false; 
	public static boolean DEBUG_MODE = true; 
	
	private static int playerCount; 
	
	private static int roundNumber = 1; 
	
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
		try {
			mainGameLoop();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}
	
	private static void mainGameLoop() throws InterruptedException {
		System.out.println("Welcome to The Money Game!\n  ---   ");	
		game = new Game(); 
		playerCount = board.getPlayers().size(); 
		setTurnOrder();
		while(!gameWon){
			System.out.println("Round # " + roundNumber++);
			gameWon = nextRound(); 	
//			endGame(); 
		}
	}
	
	
	/**
	 * Each round consists of a turn from each player
	 * @return
	 * @throws InterruptedException 
	 */
	private static boolean nextRound() throws InterruptedException {
		for (int i = 0; i < playerCount; i++){
			gameWon = nextTurn(i); 
		}	
		return false; 
	}
	
	/**
	 * This method contains all the turn logic for each turn
	 * @param playerIndex
	 * @return 
	 * @throws InterruptedException 
	 */
	private static boolean nextTurn(int playerIndex) throws InterruptedException {

		Player currentPlayer = board.getPlayers().get(playerIndex); 
		String currentPlayerName = currentPlayer.getName(); 
		System.out.println(currentPlayerName + " is up next!");
		
		int total = rollDie(currentPlayer); 
		
		
		if (currentPlayer.getPlayerToken().checkIfJailed()){
			if (currentPlayer.getJailCards() > 0) {
				// use get out of jail free card
			}
			int[] rolls = board.getDie().roll(); 
			if (rolls[0] == rolls[1]){
				// get out of jail free
			}
		}
		
		int oldPosition = currentPlayer.getPlayerToken().getPosition(); 
		boolean passedGo = incrementPosition(total, currentPlayer.getPlayerToken());
		System.out.println(currentPlayer.getName() +" moved from " + oldPosition + " to " + currentPlayer.getPlayerToken().getPosition() + ".");  
		
		ArrayList<Space> spaces = board.getSpaces(); 
		Space currentSpace = spaces.get(currentPlayer.getPlayerToken().getPosition()); 
		
		
		// check what type of space it is 
		// if it's go, collect 200 
		// if it's go to jail, go to jail
		// if it's free parking, do nothing
		// if it's card draw space, draw card 
		// if it's property, check if owned
		//		if owned, pay rent to owner 
		// 		if unowned, ask if player wants to buy 
		//			if player declines, start auction 
		
		//Line Spacer
		Thread.sleep(250);
		System.out.println("");
		return false; 
	}
	
	
	private static int rollDie(Player currentPlayer) throws InterruptedException{
		Die die = board.getDie(); 
		int[] rolls = die.roll(); 
		int rollTotal = rolls[0]+rolls[1]; 
		System.out.println(currentPlayer.getName() + " rolled [" + rolls[0] + "] & [" + rolls[1] + "] (Total:" + rollTotal + ")" );
		if (rolls[0] == rolls[1]){
			System.out.println("Rolled doubles!");
			boolean shouldGoToJail = currentPlayer.rolledDoubles();
			if (shouldGoToJail){
				System.out.println("Uh oh, " + currentPlayer.getName() + " is going to jail for rolling 3 doubles!" );
				Thread.sleep(500);
				// send this player to jail! 
			}
			Thread.sleep(500);
		}
		else {
			currentPlayer.resetDoubleCount();
		}
		
		return rollTotal; 
	}
	
	/**
	 * Moves the player by a given number of spaces
	 * @param magnitude 
	 * @return Returns true if the player passes go, returns false otherwise. 
	 */
	public static boolean incrementPosition(int magnitude, PlayerToken token) {
		int newPosition = token.getPosition() + magnitude; 
		if (Game.getDebugMode()){			
			System.out.println("magnitude " + magnitude);
			System.out.println("new position (nonmod)" + newPosition);
			
			if (newPosition > Board.TOTAL_NUMBER_OF_SPACES) {
				System.out.println("new position (mod)" + newPosition);
			}
		}
		token.setPosition(newPosition % Board.TOTAL_NUMBER_OF_SPACES);
		if (newPosition > Board.TOTAL_NUMBER_OF_SPACES ) { 
			return true; 
		}
		return false; 
	}
	
	private static void setTurnOrder() throws InterruptedException{
		System.out.println("\nRandomizing turn order...");
		Thread.sleep(300);
		Collections.shuffle(board.getPlayers());
		System.out.println(board.getPlayers().get(0).getName() + " goes first!\n");
	}

	public static void endGame() { gameWon = true; }
	public Board getBoard() { return board; }
	public static Bank getBank() { return bank; }
	public static boolean getDebugMode() { return DEBUG_MODE; }
}
