package com.flippedshield.monopoly.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.flippedshield.monopoly.Card;
import com.flippedshield.monopoly.Deed;
import com.flippedshield.monopoly.Game;
import com.flippedshield.monopoly.PlayerToken;
import com.flippedshield.monopoly.Space;

public class WhenANewGameIsStarted {
	
	private Game game;
	
	@Before
	public void setUp() throws Exception
	{
		game = new Game();
	}
	

	@Test
	public void ShouldCreateTheBoard() {
		assertNotNull(game.getBoard());
	}
	
	@Test
	public void ShouldCreateTheBank() {
		assertNotNull(game.getBank());
	}
	
	@Test
	public void ShouldAddPlayersToBoard()
	{
		assertNotNull(
				game
					.getBoard()
					.getPlayers());
	}
	
	@Test
	public void ShouldAddDieToBoard()
	{
		assertNotNull(
				game
					.getBoard()
					.getDie());
	}
	
	@Test
	public void ShouldHaveBigFunCards()
	{
		assertNotNull(
				game
					.getBoard()
					.getBigFunCards());
	}
	
	@Test
	public void ShouldHaveBigFunCardsWithValidData()
	{
		ArrayList<Card> cards = game.getBoard().getBigFunCards();
		
		if(cards.isEmpty())
		{
			fail("Big Fun card deck is empty");
			
		} else
		{
			for(Card c : cards)
			{
				if(c.getName().isEmpty() || c.getName() == null)
				{
					fail("Card " + cards.indexOf(c) + " had an empty name");
				}
			}
		}
	}
	
	@Test
	public void ShouldHaveContingencyCards()
	{
		assertNotNull(
				game
					.getBoard()
					.getContingencyCards());
	}
	
	@Test
	public void shouldHaveContingencyCardsWithValidData()
	{
		ArrayList<Card> cards = game.getBoard().getContingencyCards();
		
		if(cards.isEmpty())
		{
			fail("Contingency card deck is empty");
			
		} else
		{
			for(Card c : cards)
			{
				if(c.getName().isEmpty() || c.getName() == null)
				{
					fail("Card " + cards.indexOf(c) + " had an empty name");
				}
			}
		}
	}
	
	@Test
	public void ShouldHaveSpacesOnBoard(){
		assertNotNull(
				game
					.getBoard()
					.getSpaces());
	}
	
	@Test
	public void ShouldHaveDeedsInBank(){
		assertNotNull(
				game
					.getBank()
					.getDeeds()); 
	}
	
	@Test
	public void bankShouldHaveDeedsWithValidData()
	{
		ArrayList<Deed> deeds = game.getBank().getDeeds();
		boolean isValid = false;
		
		if(deeds.isEmpty())
		{
			fail("Deeds list is empty");
			
		} else
		{
			for (Deed d : deeds){
				if(!d.getName().isEmpty() && d.getOwner() != null && d.getMortgage() > 0 && d.getBaseRent() > 0)
				{
					isValid = true;
				}
				assertTrue("Deed #" + deeds.indexOf(d) + " is not valid", isValid);
			}
		}
	}
	
	@Test 
	public void tokensShouldHaveNamesAndSymbols(){
		ArrayList<PlayerToken> playerTokens = game.getBoard().getTokens(); 
		if (playerTokens.isEmpty()){
			fail("player tokens list was empty."); 
		}
		for (PlayerToken pt : playerTokens){
			if (pt.getName().isEmpty() || pt.getName() == null){
				fail("Token #" + playerTokens.indexOf(pt) + " name was empty"); 
			}
		}
	}

}
