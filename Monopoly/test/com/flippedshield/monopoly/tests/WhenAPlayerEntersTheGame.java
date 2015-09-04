package com.flippedshield.monopoly.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.flippedshield.monopoly.Deed;
import com.flippedshield.monopoly.Game;
import com.flippedshield.monopoly.Player;

public class WhenAPlayerEntersTheGame {
	
	private Game game;
	private ArrayList<Player> players;

	@Before
	public void setUp() throws Exception 
	{
		game = new Game();
		players = game.getBoard().getPlayers(); 
	}

	@Test
	public void shouldHaveAName()
	{
		String name;
		
		for(Player p : players)
		{
			name = p.getName();
			assertTrue("Player " + players.indexOf(p) + " had no name", !name.isEmpty());
		}
	}
	
	@Test 
	public void shouldHaveNoDoubleRollHistory()
	{
		int lastTwoRolls;
		
		for(Player p : players)
		{
			lastTwoRolls = p.getconsecutiveDoubleCount();
			assertTrue("Player " + players.indexOf(p) + " had a bad roll history", lastTwoRolls >= 0);
		}
	}
	
	@Test 
	public void shouldHaveStartingWealth()
	{
		int wealth;
		
		for(Player p : players)
		{
			wealth = (int) p.getWealth();
			assertTrue("Player " + players.indexOf(p) + " had no wealth", wealth > 0);
		}
	}
	
	@Test 
	public void shouldHaveNoJailCards()
	{
		int jailCards;
		
		for(Player p : players)
		{
			jailCards = p.getJailCards();
			assertTrue("Player " + players.indexOf(p) + " should have had 0 jail cards", jailCards == 0);
		}
	}
	
	@Test 
	public void shouldHaveEmptyListOfDeeds()
	{
		ArrayList<Deed> deeds;
		
		for(Player p : players)
		{
			deeds = p.getOwnedDeeds();
			assertTrue("Player " + players.indexOf(p) + " should have had no deeds", deeds.isEmpty());
		}
	}
	
	@Test 
	public void shouldHaveAssociatedToken(){
		for (Player p : players){
			assertNotNull(p.getPlayerToken()); 
		}
	}

}
