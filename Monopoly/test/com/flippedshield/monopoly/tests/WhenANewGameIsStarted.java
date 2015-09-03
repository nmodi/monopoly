package com.flippedshield.monopoly.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.flippedshield.monopoly.Card;
import com.flippedshield.monopoly.Deed;
import com.flippedshield.monopoly.Game;
import com.flippedshield.monopoly.Space;

public class WhenANewGameIsStarted {
	
	private Game game;
	
	@Before
	public void startup()
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
	public void SpacesShouldHaveNames()
	{
		ArrayList<Space> spaces = game.getBoard().getSpaces();
		
		if(spaces.isEmpty())
		{
			fail("Spaces list is empty");
			
		} else
		{
			for (Space s : spaces){
				if (s.getName().isEmpty() || s.getName() == null){
					fail("Space #" + spaces.indexOf(s) + " name was empty"); 
				}
			}
		}
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
		
		if(deeds.isEmpty())
		{
			fail("Deeds list is empty");
			
		} else
		{
			for (Deed d : deeds){
				if (d.getName().isEmpty() || d.getName() == null){
					fail("Space #" + deeds.indexOf(d) + " name was empty"); 
				}
			}
		}
	}
	
	@Test 
	public void tokensShouldHaveNamesAndSymbols(){
		game.getBoard().getTokens(); 
	}

}
