package com.flippedshield.monopoly.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.flippedshield.monopoly.Board;
import com.flippedshield.monopoly.Game;
import com.flippedshield.monopoly.Player;
import com.flippedshield.monopoly.Space;
import com.flippedshield.monopoly.TaxSpace;

public class WhenAPlayerLandsOnATaxSpace {

	private Game game;
	private Board board;
	private Player player;
	
	@Before
	public void setUp() throws Exception {
		game = new Game();
		board = game.getBoard();
		
	}

	@Test
	public void shouldRemoveWealthFromThePlayer() 
	{
		int taxCost;
		int expectedWealth;
		TaxSpace taxSpace = null;
		
		player = board.getPlayers().get(0);
		
		for(Space s : board.getSpaces())
		{
			if(!s.equals(TaxSpace.class))
			{
				Game.incrementPosition(1, player.getPlayerToken());
				
			} else if(s.equals(TaxSpace.class))
			{
				taxSpace = (TaxSpace) s;
				break;
			}
		}
		
		System.out.println("WEALTH " + player.getWealth());
		System.out.println("TAX " + taxSpace.getTaxCost());
		expectedWealth = (int) (player.getWealth() - taxSpace.getTaxCost());
		player.adjustWealth(taxSpace.getTaxCost());
		
		assertTrue("Did not remove wealth from player", expectedWealth == player.getWealth());
		
	}
	
	@Test
	public void shouldGiveWealthToFreeParking()
	{
		fail("Not yet implemented");
	}

}
