package com.flippedshield.monopoly.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.flippedshield.monopoly.Card;
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
	public void ShouldHaveChanceCards()
	{
		assertNotNull(
				game
					.getBoard()
					.getChanceCards());
	}
	
	@Test
	public void ShouldHaveChanceCardsWithValidData()
	{
		ArrayList<Card> cards = game.getBoard().getChanceCards();
		
		if(cards.isEmpty())
		{
			fail("Chance cards deck is empty");
			
		} else
		{
			for(Card c : cards)
			{
				if(c.getName().isEmpty())
				{
					fail("Card " + cards.indexOf(c) + " had an empty name");
				}
			}
		}
	}
	
	@Test
	public void ShouldHaveCommunityCards()
	{
		assertNotNull(
				game
					.getBoard()
					.getCommunityCards());
	}
	
	@Test
	public void ShouldHaveSpacesOnBoard(){
		assertNotNull(
				game
					.getBoard()
					.getSpaces());
	}
	
	@Test
	public void SpacesShouldHaveNames(){
		ArrayList<Space> spaces = game.getBoard().getSpaces();
		for (Space s : spaces){
			if (s.getName().isEmpty()){
				fail("Space #" + spaces.indexOf(s) + " name was empty"); 
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

}
